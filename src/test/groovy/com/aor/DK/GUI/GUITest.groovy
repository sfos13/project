package com.aor.DK.GUI

import com.aor.DK.model.Position
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen
import spock.lang.Specification

class GUITest extends Specification{
    LanternaGUI lanternaGUI = new LanternaGUI(30,30)

    def 'screen must close'() {
        given:
        Screen screen = Mock()
        when:
        lanternaGUI.close(screen)
        then:
        1 * screen.close()
    }
 /*
    def 'testing next Action'(){
        given:
        lanternaGUI.pressedKeys.a
        when:
        lanternaGUI.getNextActions()
    }

    def 'testing draw Mario'(){
        given:
        def position = new Position(1,1)
        when:
        lanternaGUI.drawMario(position, 'M' as char)
        then:
        lanternaGUI.getScreen().getBackCharacter(new TerminalPosition(1,1)).equals('M' as char)
    }


  */

}
