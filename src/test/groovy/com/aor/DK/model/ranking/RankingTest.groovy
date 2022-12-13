package com.aor.DK.model.ranking

import spock.lang.Specification

class RankingTest extends Specification{
    def 'Testing add person'(){
        given:
        def ranking = new Ranking()
        def list = new ArrayList<RankingElement>()
        list.add(new RankingElement("A",10,10))
        list.add(new RankingElement("B",10,10))
        list.add(new RankingElement("C",10,10))
        list.add(new RankingElement("D",10,10))
        list.add(new RankingElement("E",10,10))
        list.add(new RankingElement("F",10,10))
        list.add(new RankingElement("G",10,10))
        list.add(new RankingElement("H",10,10))
        list.add(new RankingElement("I",10,10))
        list.add(new RankingElement("J",10,10))
        when:
        ranking.setList(list)
        ranking.addPerson(new RankingElement("X",10,10))
        then:
        ranking.getPeople().get(9).getName() == "X"
    }
}
