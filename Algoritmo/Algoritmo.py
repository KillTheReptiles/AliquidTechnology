import json 
from nltk.chat.util import Chat, reflections

# Opening JSON files 
with open('1preguntas_tipo_computador.json', 'r',encoding='utf8') as openfile: 
    preguntas = json.load(openfile)#.encoding='utf8'
  

  
with open('for_work.json', 'r',encoding='utf8') as openfile: 
    for_work = json.load(openfile) 

with open('gaming.json', 'r',encoding='utf8') as openfile: 
    gaming = json.load(openfile) 

with open('netbook.json', 'r',encoding='utf8') as openfile: 
    netbook = json.load(openfile) 

with open('notebook.json', 'r',encoding='utf8') as openfile: 
    notebook = json.load(openfile) 

with open('two_in_one_convertible.json', 'r',encoding='utf8') as openfile: 
    two_in_one = json.load(openfile) 

with open('ultrabook.json', 'r',encoding='utf8') as openfile: 
    ultrabook = json.load(openfile)


preguntas2 = []

for i in preguntas:
    a = [i,[preguntas.get(i)]]
    preguntas2.append(a)
    
print(preguntas2)

chat = Chat(preguntas2, reflections)
chat.converse()

