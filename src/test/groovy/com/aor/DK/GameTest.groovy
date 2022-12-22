package com.aor.DK

import spock.lang.Specification

import com.aor.DK.GUI.LanternaGUI


class GameTest extends Specification {
    Game game
    LanternaGUI gui

    def setup() {
        gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        game = new Game()
    }

    def 'Testing setState method'() {
        when:
        game.setState(null)

        then:
        game.state == null
    }

}
