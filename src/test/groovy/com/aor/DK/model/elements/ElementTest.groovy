package com.aor.DK.model.elements

import com.aor.DK.model.Position
import spock.lang.Specification

class ElementTest extends Specification{
    def 'get element position'() {
        given:
            def m = new Mario(2,3)
            def p = new Position(2,3)
        expect:
            m.getPosition() == p
    }

    def 'set element position'() {
        given:
            def m = new Mario(2,3)
            def p = new Position(1,4)
        when:
            m.setPosition(p)
        then:
            m.getPosition() == p
    }

    def 'get Mario velocity'() {
        given:
            def m = new Mario(2,3)
        expect:
            0f == m.getVy()
    }

    def 'set Mario velocity'() {
        given:
            def m = new Mario(2,3)
        when:
            m.setVy(2)
        then:
            2f == m.getVy()
    }

    def 'increment Mario velocity'() {
        given:
            def m = new Mario(2,3)
        when:
            m.setVy(2)
            m.incrementVy(1)
        then:
            3f == m.getVy()
    }

}
