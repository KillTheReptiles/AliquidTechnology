from flask import Flask
from flask_restful import Resource, Api
from Bot_methods import ElBot

bot = ElBot()
app = Flask(__name__)
api = Api(app)

class HelloWorld(Resource):

    def get(self, mensaje_usuario):

        mensaje = bot.chatbot_response(mensaje_usuario)

        return 'Ali: '+ mensaje

api.add_resource(HelloWorld, '/chatbot/<mensaje_usuario>')

if __name__ == '__main__':
    app.run(debug=True, threaded=False)