package com.aor.DK.controller
/*
package com.aor.DK.controller


import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.controller.game.BarrelController
import com.aor.DK.model.arena.Arena
import spock.lang.Specification

class BarrelControllerTest extends Specification{
    /*
    def'Step spawing test'() {
        given:
        def game = new Game()
        def guiList = new ArrayList<GUI.ACTION>()
        def arena = new Arena (10,10)
        def barrelController = new BarrelController(arena)
        arena.spawnBarrel() >> true
        when:
        barrelController.step(game, guiList, 2001)
        then:
        1 * arena().spawnBarrel();
}
     */

import com.aor.DK.controller.game.BarrelController
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Stair
import spock.lang.Specification

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.controller.rules.UnderStairs
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Barrel

class BarrelControllerTest extends Specification {
    BarrelController barrelController
    Arena arena

    def setup() {
        arena = new Arena(10,10)
        barrelController = new BarrelController(arena)
    }

    def "test move barrel down method"() {
        given:
        def stair = new ArrayList()
        stair.add(new Stair(1,1))
        arena.stairs = stair
        def floor = new ArrayList()
        floor.add(new ArrayList())
        floor.get(0).add(new Floor (1,1))
        arena.setFloor(floor)
        def barrel = new Barrel(1,1)
        when:
        barrelController.moveBarrel(barrel)
        then:
        barrel.getPosition().y == 2
    }

    def "test move barrel left method"() {
        given:
        def stair = new ArrayList()
        stair.add(new Stair(0,0))
        arena.stairs = stair
        def floor = new ArrayList()
        floor.add(new ArrayList())
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        def barrel = new Barrel(1,1)
        when:
        barrelController.moveBarrel(barrel)
        then:
        barrel.getPosition().x == 0
    }

    def "test move barrel right method"() {
        given:
        def stair = new ArrayList()
        stair.add(new Stair(0,0))
        arena.stairs = stair
        def floor = new ArrayList()
        floor.add(new ArrayList())
        floor.add(new ArrayList())
        floor.get(1).add(new Floor (1,2))
        arena.setFloor(floor)
        def barrels = new ArrayList()
        barrels.add(new Barrel(1,1))
        arena.setBarrels(barrels)
        def game = Mock(Game.class)
        when:
        barrelController.step(game, new ArrayList<GUI.ACTION>(), 1000)
        then:
        arena.getBarrels().get(0).getPosition().x == 2
    }

}

