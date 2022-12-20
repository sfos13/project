package com.aor.DK

import spock.lang.Specification

import com.aor.DK.GUI.LanternaGUI


class GameTest extends Specification {
    def game
    def gui

    def setup() {
        gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        game = new Game()
    }

    def "test game object is not null"() {
        expect:
        game != null
    }

    def "test setState method"() {
        when:
        game.setState(null)

        then:
        game.state == null
    }

}
