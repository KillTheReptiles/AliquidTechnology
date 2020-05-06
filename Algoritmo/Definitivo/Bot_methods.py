import pickle
import nltk
from nltk.stem import WordNetLemmatizer
import numpy as np
# from keras.models import load_model
from tensorflow.keras.models import load_model
from baseDatos import db


class ElBot:
    def __init__(self):
        self.test = "test"
        self.lemmatizer = WordNetLemmatizer()
        self.model = load_model('chatbot_model.h5')
        self.words = pickle.load(open('words.pkl', 'rb'))
        self.classes = pickle.load(open('classes.pkl', 'rb'))
        self.colPQRS = db["preguntasNuevas"]

        self.intents = []
        for contPregunta in self.colPQRS.find():
            self.intents.append(contPregunta)

        self.categoriaFinal = ""
        self.escogida = False

        self.especificaciones = {

            1: "Company",
            2: "Product",
            3: "Inches",
            4: "ScreenResolution",
            5: "Cpu",
            6: "Ram",
            7: "Memory",
            8: "Gpu",
            9: "OpSys",
            10: "Weight",
            11: "Price_euros"

        }

    def clean_up_sentence(self, sentence):
        sentence_words = nltk.word_tokenize(sentence)
        sentence_words = [self.lemmatizer.lemmatize(word.lower()) for word in sentence_words]
        return sentence_words

    def bow(self, sentence, words, show_details=True):

        sentence_words = self.clean_up_sentence(sentence)

        bag = [0] * len(words)
        for s in sentence_words:
            for i, w in enumerate(words):
                if w == s:

                    bag[i] = 1
                    if show_details:
                        print("found in bag: %s" % w)
        return (np.array(bag))

    def predict_class(self, sentence, model):

        p = self.bow(sentence, self.words, show_details=False)
        res = model.predict(np.array([p]))[0]
        ERROR_THRESHOLD = 0.25
        results = [[i, r] for i, r in enumerate(res) if r > ERROR_THRESHOLD]

        results.sort(key=lambda x: x[1], reverse=True)
        return_list = []
        for r in results:
            return_list.append({"intent": self.classes[r[0]], "probability": str(r[1])})
        return return_list

    def getResponse(self, ints, intents):
        tag = ints[0]['intent']
        list_of_intents = intents
        for i in list_of_intents:
            if (i['tag'] == tag):
                result = i['respuestas']

                break
        return result

    def chatbot_response(self, msg):

        if ((len(msg) == 2 or len(msg) == 1) and self.categoriaFinal != ''):
            msg = int(msg)
            tipo_compu = db[self.categoriaFinal]
            if (
                    msg == 1 or msg == 2 or msg == 3 or msg == 4 or msg == 5 or msg == 6 or msg == 7 or msg == 8 or msg == 9 or msg == 10 or msg == 11):
                esp = self.especificaciones[msg]
                res = ""

                listEsp = []

                for conteCompu in tipo_compu.find():
                    # db.inventory.find( { }, { "Product": 1, _id: 0 } )

                    dictKey = conteCompu[esp]

                    listEsp.append([conteCompu['Product'], dictKey])

                #                listEsp.sort()
                res += "Aqui estan los primeros 5 computadores de tu interes:\n"

                for i in listEsp[0:5]:
                    res += "* Nombre: " + str(i[0]) + "\n- " + esp + ": " + str(i[1]) + "\n"
                res += "\n"
            else:
                res = "No haz marcado ninguna de las opciones! :(, pregunta de nuevo :D"

        else:
            ints = self.predict_class(msg, self.model)
            tag = ints[0]['intent']
            print("<TAG> " + tag)

            res = self.getResponse(ints, self.intents) + ""

        return res


if __name__ == '__main__':
    bot = ElBot()
    while True:
        msg = input()
        if (len(msg) > 2):

            ints = bot.predict_class(msg, bot.model)
            tag = ints[0]['intent']

            if (tag != "saludos" and tag != "despedidas" and tag != "preguntasAmables" and tag != "sinRespuesta"):
                bot.categoriaFinal = tag

        res = bot.chatbot_response(msg)

        print(res)
