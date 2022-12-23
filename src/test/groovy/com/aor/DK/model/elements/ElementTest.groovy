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

}
