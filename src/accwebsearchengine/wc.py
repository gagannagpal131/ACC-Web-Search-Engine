import requests
from bs4 import BeautifulSoup
import os
import re
clear = lambda: os.system('cls')
clear()
WEBLEN = 1000
webLists = ['http://www.uwindsor.ca']
def web(page,WebUrl):
    if(page>0):
        url = WebUrl
        code = requests.get(url)
        plain = code.text
        s = BeautifulSoup(plain, "html.parser")
        for link in s.findAll('a'):
            tet_2 = link.get('href')
            if tet_2 != None:
                find = re.findall("http",tet_2)
                if find:
                    if len(webLists)<WEBLEN:
                        webLists.append(tet_2)
for i in webLists:
    if len(webLists)<WEBLEN:
        web(1,i)
    else:
        break
print("ENDD!!!!!!!!!!")
print(webLists)