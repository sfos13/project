package com.aor.DK.model.ranking

import spock.lang.Specification

class RankingElementTest extends Specification{

    def 'Testing set and get score'(){
        given:
        def element = new RankingElement("X", 10, 10)
        when:
        element.setScore(100)
        then:
        element.getScore() == 100
    }
}
