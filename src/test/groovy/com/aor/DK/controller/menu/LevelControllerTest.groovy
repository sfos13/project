package com.aor.DK.controller.menu

import com.aor.DK.Game
import com.aor.DK.model.menu.Level
import spock.lang.Specification

class LevelControllerTest extends Specification{

    def'Testing level controller step'(){
        given:
        def levelController = new LevelController(new Level(1,100))
        def game = Mock(Game.class)
        when:
        levelController.step(game,[],System.currentTimeMillis() + 4000)
        then:
        1 * game.setState(_)
    }

}
