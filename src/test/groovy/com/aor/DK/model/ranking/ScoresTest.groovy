package com.aor.DK.model.ranking

import spock.lang.Specification

class ScoresTest extends Specification{
    Scores scores

    def setup(){
        scores = new Scores(1,1)
    }
    def 'Testing set/get jump score'(){
        when:
        scores.setJumpScore()
        then:
        scores.getJumpScore() == 100
    }

    def 'Testing set/get time score'(){
        when:
        scores.setTimeScore()
        then:
        scores.getTimeScore() == 5000
    }
}
