#let's begin

import json

preguntas = {"Hola|hola|buen(.*)":"Hola, me llamo Ali, y estoy para atenderte. ¿Qué tipo de computador necesitas? Tenemos para jugar,de oficina,notebook,netbook,ultrabook y 2 en 1.",
"(.*) (precio|barato|caro)": "Tenemos las siguientes categorias: gaming, oficina, notebook, 2 en 1 netbook,ultrabook",
"(.*) (gaming|juegos|jugar|gamer)":"Tenemos los siguientes computadores para jugar",
"(.*) (oficina|trabajar|laborar)":"Tenemos los siguientes computadores para ello",
"(.*) (notebook|ligero)":"Tenemos los siguientes computadores tipo notebook",
"(.*) (2 en 1|desmontable|convertible|dos en uno|tablet)":"Tenemos los siguientes computadores tipo 2 en 1",
"(.*) (netbook|pequeño|mini|minilaptop)":"Tenemos los siguientes computadores tipo netbook",
"(.*) (ultrabook|grande|amplio)":"Tenemos los siguientes computadores tipo ultrabook"}

with open('preguntas_tipo_computador.json', 'w', encoding='utf8') as json_file:
    json.dump(preguntas, json_file, ensure_ascii=False)