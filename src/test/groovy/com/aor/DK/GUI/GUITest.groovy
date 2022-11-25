package com.aor.DK.GUI


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
}
