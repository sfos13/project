package com.aor.DK.viewer.ranking

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.Game
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

import java.awt.event.ActionEvent

class PlayerNameGUITest extends Specification{
   def 'Testing action button ok'(){
        given:
        Ranking ranking = new Ranking()
        Game game = Mock(Game.class, constructorArgs:[new LanternaGUI(10,10)])
        PlayerNameGUI gui = new PlayerNameGUI(game, 1000)
        int size = ranking.getList().size()
        when:
        gui.actionButtonOk(new ActionEvent(new Object(), 1, ""))
        then:
        ranking.getList().get(size - 1).score == 1000
        cleanup:
        ranking.getList().remove(size - 1)
        ranking.save()
    }

}
