# -*- coding: utf-8 -*-
"""
@author: Miguel Oyler-Castrillo
"""
from urllib import urlopen
from bs4 import BeautifulSoup
import bs4
import requests
import re

def extract_source(url):
     agent = {"User-Agent":"Mozilla/5.0"}
     source=requests.get(url, headers=agent).text
     return source

def getTeamNames(source, region=''):
     soup=bs4.BeautifulSoup(source, 'lxml')
     names= soup.findAll('span', {'class' : re.compile('fi-t__nText')})
     teamList = []
     for i in names:
         teamList.append(i.get_text())
     return teamList
         
def getRankPairs(source, region=''):
     soup=bs4.BeautifulSoup(source, 'lxml')
     names= soup.findAll('td', {'class' : re.compile('points')})
     currPtsList = []
     prevPtsList = []
     cnt = 0
     for i in names:
         if cnt % 2 == 0:
             currPtsList.append(i.get_text())
         else:
             prevPtsList.append(i.get_text())
         cnt += 1
         #print i.get_text()
     ptsTupleList = []
     for i, j in zip(currPtsList, prevPtsList):
         ptsTupleList.append((int(i.encode('utf-8')),int(j.encode('utf-8'))))
     return ptsTupleList
         
def generateDict(teamList, tupleList):
    team_dict = {}
    for i in range(len(teamList)):
        team_dict[teamList[i]] = (tupleList[i])
    return team_dict

region = '#UEFA'

teamList = getTeamNames(extract_source('https://www.fifa.com/fifa-world-ranking/ranking-table/men/'))
teamRank = getRankPairs(extract_source('https://www.fifa.com/fifa-world-ranking/ranking-table/men/'))


teamDict = generateDict(teamList, teamRank)
for k, v in teamDict.items():
    print(k)
    print(v)
print(len(teamList))
