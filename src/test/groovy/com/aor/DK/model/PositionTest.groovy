package com.aor.DK.model

import spock.lang.Specification

class PositionTest extends Specification{

    def 'build position'() {
        given:
            def p = new Position(2,3)
        expect:
            2 == p.getX()
            3 == p.getY()
    }

    def 'get position on the left'() {
        given:
            def p = new Position(2,3)
        when:
            p = p.getLeft()
        then:
            p == new Position(1,3)
    }

    def 'get position on the right'() {
        given:
            def p = new Position(2,3)
        when:
            p = p.getRight()
        then:
            p == new Position(3, 3)
    }

    def 'get position up'() {
        given:
        def p = new Position(2,3)
        when:
        p = p.getUp()
        then:
        p == new Position(2, 2)
    }

    def 'get position down'() {
        given:
        def p = new Position(2,3)
        when:
        p = p.getDown()
        then:
        p == new Position(2, 4)
    }

}
