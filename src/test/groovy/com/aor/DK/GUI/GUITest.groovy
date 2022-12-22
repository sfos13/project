package com.aor.DK.GUI


import spock.lang.Specification

import java.awt.event.KeyEvent

class GUITest extends Specification{
    LanternaGUI lanternaGUI = new LanternaGUI(30,30)
/*
    def 'screen must close'() {
        given:
        Screen screen = Mock()
        when:
        lanternaGUI.close(screen)
        then:
        1 * screen.close()
    }
*/
    def 'testing next Action'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_SPACE)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.SPACE)
    }
/*
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
