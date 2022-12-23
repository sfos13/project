package com.aor.DK.controller.game

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.*
import spock.lang.Specification

class MarioControllerTest extends Specification {

    Arena arena
    MarioController marioController
    Game game
    List stair
    List floor
    List switches

    def setup() {
        arena = new Arena(10, 10)
        arena.setMario(new Mario(1, 2))
        arena.setDonkeyKong(new DonkeyKong(0, 0))
        arena.setPrincess(new Princess(0, 0))
        marioController = new MarioController(arena)
        game = new Game(null)
        stair = new ArrayList()
        floor = new ArrayList()
        floor.add(new ArrayList())
        switches = new ArrayList()
    }


    def 'Testing move mario up'() {
        given:
        stair.add(new Stair(1, 2))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 3))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        when:
        marioController.step(game, [GUI.ACTION.UP], System.currentTimeMillis() + 100)
        then:
        arena.getMario().getPosition().y == 1
    }

    def 'Testing move mario down'() {
        given:
        stair.add(new Stair(1, 3))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 4))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        when:
        marioController.step(game, [GUI.ACTION.DOWN], System.currentTimeMillis() + 100)
        then:
        arena.getMario().getPosition().y == 3
    }

    def 'Testing move mario left'() {
        given:
        stair.add(new Stair(0, 0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 3))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        when:
        marioController.step(game, [GUI.ACTION.LEFT], System.currentTimeMillis() + 100)
        then:
        arena.getMario().getPosition().x == 0
    }

    def 'Testing move mario right'() {
        given:
        stair.add(new Stair(0, 0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 3))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        when:
        marioController.step(game, [GUI.ACTION.RIGHT], System.currentTimeMillis() + 100)
        then:
        arena.getMario().getPosition().x == 2
    }

    def 'Testing step mario jump'() {
        given:
        stair.add(new Stair(0, 0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 3))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        when:
        marioController.step(game, [GUI.ACTION.SPACE], System.currentTimeMillis() + 100)
        then:
        arena.getMario().getPosition().y == 0
    }

    def 'Testing step mario jump score test'() {
        given:
        stair.add(new Stair(0, 0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor(1, 3))
        arena.setFloor(floor)
        switches.add(new Switch(0, 0))
        arena.setSwitches(switches)
        def barrels = new ArrayList()
        barrels.add(new Barrel(0, 2))
        arena.setBarrels(barrels)
        when:
        marioController.step(game, [GUI.ACTION.SPACE], System.currentTimeMillis() + 100)
        then:
        arena.scores.getJumpScore() == 100
    }

    def 'Testing step level 1'(){
        given:
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,3))
        arena.setFloor(floor)
        switches.add(new Switch(0,0))
        arena.setSwitches(switches)
        arena.setLevel(1)
        when:
        marioController.step(game,[GUI.ACTION.WIN],0)
        then:
        game.getState().getModel().getLevel() == 2

    }

    def 'Testing step level 2'(){
        given:
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,3))
        arena.setFloor(floor)
        switches.add(new Switch(0,0))
        arena.setSwitches(switches)
        arena.setLevel(2)
        when:
        marioController.step(game,[GUI.ACTION.WIN],0)
        then:
        game.getState().getModel().getLevel() == 21
    }

    def 'Testing step winning game'(){
        given:
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,3))
        arena.setFloor(floor)
        switches.add(new Switch(0,0))
        arena.setSwitches(switches)
        arena.setLevel(21)
        when:
        marioController.step(game,[GUI.ACTION.WIN],0)
        then:
        game.getState().getModel().getMod() == "Win"
    }

    def 'Testing step is crash'(){
        given:
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,3))
        arena.setFloor(floor)
        switches.add(new Switch(0,0))
        arena.setSwitches(switches)
        def barrels = new ArrayList()
        barrels.add(new Barrel(1, 2))
        arena.setBarrels(barrels)
        when:
        marioController.step(game,[],0)
        then:
        game.getState().getModel().getMod() == "Lost"
    }


}
