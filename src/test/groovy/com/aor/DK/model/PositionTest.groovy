package com.aor.DK.model

import spock.lang.Specification

class PositionTest extends Specification{

    Position p

    def setup(){
        p = new Position(2,3)
    }

    def 'build position'() {
        expect:
            2 == p.getX()
            3 == p.getY()
    }

    def 'get position on the left'() {
        when:
            p = p.getLeft()
        then:
            p == new Position(1,3)
    }

    def 'get position on the right'() {
        when:
            p = p.getRight()
        then:
            p == new Position(3, 3)
    }

    def 'get position up'() {
        when:
        p = p.getUp()
        then:
        p == new Position(2, 2)
    }

    def 'get position down'() {
        when:
        p = p.getDown()
        then:
        p == new Position(2, 4)
    }

    def 'Testing get set x'(){
        when:
        p.setX(10)
        then:
        p.getX() == 10
    }

}
