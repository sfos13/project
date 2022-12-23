package com.aor.DK.viewer.ranking

import com.aor.DK.Game
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

import java.awt.event.ActionEvent

class PlayerNameGUITest extends Specification{
   def 'Testing action button ok'(){
        given:
        def ranking = new Ranking()
        def game = Mock(Game.class)
        def gui = new PlayerNameGUI(game, 1000)
        def size = ranking.getList().size()
        when:
        gui.actionButtonOk(new ActionEvent(new Object(), 1, ""))
        ranking = new Ranking()
        then:
        ranking.getList().get(size).score == 1000
        cleanup:
        ranking.getList().remove(size)
        ranking.save()
    }

}
