from flask import Flask
from flask_restful import Resource, Api
from Bot_methods import *

app = Flask(__name__)
api = Api(app)


class HelloWorld(Resource):
    def get(self,mensaje_usuario):
        mensaje = chatbot_response(mensaje_usuario)
        #mensaje = "el chat responde a:" + mensaje_usuario
        return 'Ali '+ mensaje

api.add_resource(HelloWorld, '/chatbot/<mensaje_usuario>')

if __name__ == '__main__':
    app.run(debug=True)