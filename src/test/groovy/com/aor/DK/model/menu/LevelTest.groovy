package com.aor.DK.model.menu

import spock.lang.Specification

class LevelTest extends Specification{

    def'Testing level getter'(){
        given:
        def level = new Level(1)
        when:
        def x = level.getLevel()
        then:
        x == 1
    }
}
