package com.aor.DK.model.elements

import spock.lang.Specification

class FireTest extends Specification{
    Fire fire

    def setup(){
        fire = new Fire(1,1)
    }

    def 'Testing get direction'(){
        when:
        def direction = fire.getDirection()
        then:
        direction == "right"
    }

    def 'Testing set direction'(){
        when:
        fire.setDirection("left")
        then:
        fire.getDirection() == "left"
    }

    def 'Testing moving right'(){
        when:
        def bool = fire.movingRight()
        then:
        bool
    }

    def 'Testing moving left'(){
        when:
        def bool = fire.movingLeft()
        then:
        !bool
    }

    def 'Testing switch direction from right to left'(){
        when:
        fire.switchDirection()
        then:
        fire.getDirection() == "left"
        fire.getLetter() == ('_' as char)
    }

    def 'Testing switch direction from left to right'(){
        when:
        fire.setDirection("left")
        fire.switchDirection()
        then:
        fire.getDirection() == "right"
        fire.getLetter() == (';' as char)
    }

}
