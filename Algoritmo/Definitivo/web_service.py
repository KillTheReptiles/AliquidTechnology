from flask import Flask
from flask_restful import Resource, Api
from Bot_methods import ElBot

bot = ElBot()
app = Flask(__name__)
api = Api(app)

class HelloWorld(Resource):

    def get(self, mensaje_usuario):
        msg = mensaje_usuario
        if (len(msg) > 2):

            ints = bot.predict_class(msg, bot.model)
            tag = ints[0]['intent']

            if (tag != "saludos" and tag != "despedidas" and tag != "preguntasAmables" and tag != "sinRespuesta"):
                bot.categoriaFinal = tag

        res = bot.chatbot_response(msg)

       # print(res)


        #mensaje = bot.chatbot_response(mensaje_usuario)

        return 'Ali: '+ res

api.add_resource(HelloWorld, '/chatbot/<mensaje_usuario>')

if __name__ == '__main__':
    app.run(debug=True, threaded=False)