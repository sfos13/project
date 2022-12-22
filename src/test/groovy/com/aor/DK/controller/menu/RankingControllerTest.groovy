package com.aor.DK.controller.menu

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.model.ranking.Ranking
import com.aor.DK.states.RankingState
import spock.lang.Specification

class RankingControllerTest extends Specification{

    Game game

    def setup(){
        game = new Game()
    }


    def 'Testing ranking controller test'() throws IOException{
        given:
        def rankingController = new RankingController(new Ranking())
        when:
        game.setState(new RankingState(new Ranking()))
        rankingController.step(game,[GUI.ACTION.SPACE], 100)
        then:
        game.getState().getModel().getMod() == "Start"
    }
}
