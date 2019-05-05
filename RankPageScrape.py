# -*- coding: utf-8 -*-
"""
@author: Miguel Oyler-Castrillo
"""
from urllib import urlopen
from bs4 import BeautifulSoup
import bs4
import requests
import re
import sys
reload(sys)
sys.setdefaultencoding('utf8')


def extract_source(url):
     agent = {"User-Agent":"Mozilla/5.0"} #we need to set the default browser to firefox for FIFA to allow us to scrape data
     source=requests.get(url, headers=agent).text
     return source

#this function gathers a list of team names, the highest ranking team will be the first index in the list
def getTeamNames(source, region=''):
     soup=bs4.BeautifulSoup(source, 'lxml')
     names= soup.findAll('span', {'class' : re.compile('fi-t__nText')}) #find data using apropriate tag
     teamList = []
     for i in names:
         teamList.append(i.get_text()) #add desired data to list of team names
     return teamList

#this function returns a list of tuples in the format as follows (currentPoints, PrevPoints, Region, Rank)
def getRankPairs(source, region=''):
     soup=bs4.BeautifulSoup(source, 'lxml')
     names= soup.findAll('td', {'class' : re.compile('points')}) #apropriate tags for currentPoints and prevPoints
     ranks = soup.findAll('td', {'class' : re.compile('fi-table__td fi-table__rank$')}) #tag for team's rank
     regions = soup.findAll('span', {'class' : re.compile('text')}) #apropriate tags for team's region
     regionList = []
     currPtsList = [] #initialize all lists
     prevPtsList = []
     rankList = []
     cnt = 0
     for i in names:
         if cnt % 2 == 0: #we want to add to the current points list at every other time we encounter a points data value
             currPtsList.append(i.get_text()) #on our first encounter with team points, we add to current points list
         else:
             prevPtsList.append(i.get_text()) #on every other encounter, we add to previous points list
         cnt += 1
         #print i.get_text()
     for i in regions:
         if '#' in i.get_text(): #the '#' tag denotes that there is a region name in that specific HTML line
             regionList.append(i.get_text())
     for i in ranks:
         rankList.append(i.get_text())
     ptsTupleList = []
     for i, j, p, q in zip(currPtsList, prevPtsList, regionList, rankList): #here is where we put together all our lists
         ptsTupleList.append((int(i.encode('utf-8')),int(j.encode('utf-8')), p, int(q)))
     return ptsTupleList
         
#this function takes a list of team names as input as well as a list of tuples with the rest of the team's data
#the function then maps the team name to all of its respective data from the tuple list and returns a dictionary with these
#mappings
def generateDict(teamList, tupleList):
    team_dict = {}
    for i in range(len(teamList)):
        team_dict[teamList[i]] = tupleList[i] #
    return team_dict



teamList = getTeamNames(extract_source('https://www.fifa.com/fifa-world-ranking/ranking-table/men/')) #URL source
teamRank = getRankPairs(extract_source('https://www.fifa.com/fifa-world-ranking/ranking-table/men/')) #URL source

f = open('TeamInfo.txt', 'w') #open a file to write team data into

teamDict = generateDict(teamList, teamRank)
for k, v in teamDict.items():
    f.write("{0} \n {1} \n {2} \n {3} \n {4} \n".format(k, v[3], v[0], v[1], v[2])) #format string for team data
