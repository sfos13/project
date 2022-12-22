package com.aor.DK.controller.menu

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

class RankingControllerTest extends Specification{

    def 'Testing ranking controller test'(){
        given:
        def rankingController = new RankingController(new Ranking())
        def game = new Game()
        when:
        rankingController.step(game,[GUI.ACTION.SPACE], 100)
        then:
        game.getState().getModel().getMod() == "Start"
    }
}
