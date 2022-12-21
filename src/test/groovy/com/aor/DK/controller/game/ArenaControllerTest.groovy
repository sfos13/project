package com.aor.DK.controller.game
import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.controller.game.ArenaController
import com.aor.DK.controller.game.BarrelController
import com.aor.DK.controller.game.MarioController
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.DonkeyKong
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Mario
import com.aor.DK.model.elements.Princess
import com.aor.DK.model.elements.Stair
import com.aor.DK.model.elements.Switch
import spock.lang.Specification

class ArenaControllerTest extends Specification{

    Game game
    Arena arena
    ArenaController arenaController
    List stair
    List floor

    def setup(){
        game = Mock(Game.class)
        arena = new Arena(10, 10)
        arena.setMario(new Mario(1,1))
        arenaController = new ArenaController(arena)
        arena.setDonkeyKong(new DonkeyKong(5,5))
        arena.setPrincess(new Princess(5,5))
        stair = new ArrayList()
        floor = new ArrayList()
        floor.add(new ArrayList())
    }

    def 'testing step with GUI.ACTION.QUIT'(){
        when:
        arenaController.step(game, [GUI.ACTION.QUIT],0)
        then:
        1 * game.setState(_)
    }

    def 'testing step with switches on'(){
        given:
        stair.add(new Stair(0,0))
        arena.stairs = stair
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        def switches = new ArrayList()
        switches.add(new Switch(2,2))
        arena.setSwitches(switches)
        when:
        arena.setLevel(2)
        arenaController.step(game, [],0)
        arena.getMario().setPosition(new Position(2,1))
        arenaController.step(game, [],0)
        arenaController.step(game, [],0)
        then:
        1 * game.setState(_)
    }

}

