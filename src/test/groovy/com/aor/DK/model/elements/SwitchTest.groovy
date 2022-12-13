package com.aor.DK.model.elements

import spock.lang.Specification

class SwitchTest extends Specification{
    Switch s

    def setup(){
        s = new Switch(1,1)
    }

    def 'Testing is on'(){
        when:
        def bool = s.isOn()
        then:
        bool
    }

    def 'Testing turn off'(){
        when:
        s.turnOff()
        then:
        !s.isOn()
    }
}
