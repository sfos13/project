package com.aor.DK.controller.game
import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.controller.game.ArenaController
import com.aor.DK.controller.game.BarrelController
import com.aor.DK.controller.game.MarioController
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Mario
import com.aor.DK.model.elements.Stair
import spock.lang.Specification

class ArenaControllerTest extends Specification{

    def 'testing step with GUI.ACTION.QUIT'(){
        given:
        def game = Mock(Game.class)
        def arena = new Arena(10, 10)
        def arenaController = new ArenaController(arena)
        when:
        arenaController.step(game, GUI.ACTION.QUIT,0)
        then:
        1 * game.setState(_)
    }

    /*
    def 'testing step with GUI.ACTION._'(){
        given:
        def game = Mock(Game.class)
        def arena = new Arena(10, 10)
        def arenaController = new ArenaController(arena)
        when:
        arenaController.step(game, GUI.ACTION.DOWN,0)
        then:
        arena.getMario().getPosition().equals(new Position (1,1))

    }
    */
}

