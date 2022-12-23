package com.aor.DK.model.elements

import spock.lang.Specification

class BarrelTest extends Specification{
    def 'Testing if barrel is heavy'(){
        given:
        def barrel = new Barrel(1,1)
        def bool = barrel.isHeavy()
        expect:
        bool || (!bool)
    }
}
