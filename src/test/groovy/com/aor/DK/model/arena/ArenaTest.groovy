package com.aor.DK.model.arena

import com.aor.DK.controller.rules.Crash
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Barrel
import com.aor.DK.model.elements.DonkeyKong
import com.aor.DK.model.elements.Fire
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Mario
import com.aor.DK.model.elements.Princess
import com.aor.DK.model.elements.Stair
import com.aor.DK.model.elements.Stick
import com.aor.DK.model.elements.Switch
import com.aor.DK.model.ranking.Scores
import spock.lang.Specification

class ArenaTest extends Specification{
    Arena arena

    def setup(){
       arena = new Arena(10,20)
    }

    def 'get width and height'() {
        expect:
            arena.getWidth() == 10
            arena.getHeight() == 20
    }
    def 'set and get mario'() {
        given:
            def mario = new Mario(1,2)
        when:
            arena.setMario(mario)
        then:
            mario == arena.getMario()
    }
    def 'set and get Princess'() {
        given:
        def princess = new Princess(2, 3)
        when:
        arena.setPrincess(princess)
        then:
        princess == arena.getPrincess()
    }
    def 'set and get Donkey Kong'() {
        given:
            def dk = new DonkeyKong(3,4)
        when:
            arena.setDonkeyKong(dk)
        then:
            dk == arena.getDonkeyKong()
    }
    def 'set and get barrels'() {
        given:
            List<Barrel> barrels = new ArrayList<>()
            def barrel1 = new Barrel(1,2)
            barrels.add(barrel1)
            def barrel2 = new Barrel(3,5)
            barrels.add(barrel2)
        when:
            arena.setBarrels(barrels)
        then:
            barrel1 == arena.getBarrels().get(0)
            barrel2 == arena.getBarrels().get(1)
    }
    def 'set and get floors'() {
        given:
            List<List<Floor>> floors = new ArrayList<>()
            floors.add(new ArrayList<Floor>())
            def floor1 = new Floor(3,4)
            floors.get(0).add(floor1)
            floors.add(new ArrayList<Floor>())
            def floor2 = new Floor(5,7)
            floors.get(1).add(floor2)
        when:
            arena.setFloor(floors)
        then:
            floor1 == arena.getFloor().get(0).get(0)
            floor2 == arena.getFloor().get(1).get(0)
    }

    def 'set and get sticks'() {
        given:
        List<Stick> stick = new ArrayList<>()
        def stick1 = new Stick(1,1)
        stick.add(stick1)
        when:
        arena.setSticks(stick)
        then:
        arena.getSticks().get(0) == stick1

    }
    def 'get floor number'() {
        given:
            List<List<Floor>> floors = new ArrayList<>()
            floors.add(new ArrayList<Floor>())
            def floor1 = new Floor(3,4)
            floors.get(0).add(floor1)
            floors.add(new ArrayList<Floor>())
            def floor2 = new Floor(5,7)
            floors.get(1).add(floor2)
        when:
            arena.setFloor(floors)
        then:
            1 == arena.getFloorNumber(new Position(5,6))
            -1 == arena.getFloorNumber(new Position(10,10))
    }

    def 'check if on stair' (){
        given:
        arena.stairs = new ArrayList<Stair>()
        arena.stairs.add(new Stair(1,1))
        when:
        def a1 = arena.checkStairs(new Position(1,1))
        def a2 = arena.checkStairs(new Position(2,1))
        then:
        a1
        !a2
    }

    def 'check out of bounds'(){
        when:
        def a1 = arena.outOfBounds(new Position(11,0))
        then:
        a1
    }
    
    def 'get and set spawn position'() {
        given:
            def spawnPos = new Position(1,2)
        when:
            arena.setSpawnBarrelPosition(spawnPos)
        then:
            spawnPos == arena.getSpawnBarrelPosition()
    }
    def 'spawn barrel'() {
        given:
            arena.setSpawnBarrelPosition(new Position(1,2))
        when:
            arena.spawnBarrel()
        then:
            arena.getBarrels().size() == 1
            arena.getBarrels().get(0).getPosition() == arena.getSpawnBarrelPosition()
    }

    def 'Testing getter and setter score'(){
        when:
        arena.setScores(new Scores(1,1))
        then:
        arena.getScores().getPosition() == (new Scores(1,1)).getPosition()
    }

    def 'Testing getter setter switches'(){
        when:
        arena.setSwitches(new ArrayList<Switch>())
        arena.switches.add(new Switch(1,1))
        then:
        arena.getSwitches().get(0).getPosition() == new Position(1,1)
    }

    def 'Testing getter and setter levels'(){
        when:
        arena.setLevel(1)
        then:
        arena.getLevel() == 1
    }

    def 'Testing donkey kong crash'(){
        given:
        arena.setDonkeyKong(new DonkeyKong(1,1))
        when:
        def crash = new Crash(new Position(1,1), arena)
        then:
        crash.isValid()
    }

    def 'Testing barrel crash'(){
        given:
        arena.setDonkeyKong(new DonkeyKong(1,1))
        arena.setBarrels(new ArrayList<Barrel>())
        arena.barrels.add(new Barrel(2,2))
        when:
        def crash = new Crash(new Position(2,2), arena)
        then:
        crash.isValid()
    }

    def 'Testing fire monster crash'(){
        given:
        arena.setDonkeyKong(new DonkeyKong(1,1))
        arena.fireMonsters.add(new Fire(2,2))
        when:
        def crash = new Crash(new Position(2,2), arena)
        then:
        crash.isValid()
    }

    def 'Testing spawn fire monster'(){
        given:
        arena.setSpawnFirePosition(new Position(1,1),1)
        arena.setSpawnFirePosition(new Position(2,2),2)
        when:
        arena.spawnFire()
        arena.spawnFire()
        then:
        arena.getFireMonsters().get(0).getPosition() == new Position(1,1)
        arena.getFireMonsters().get(1).getPosition() == new Position(2,2)
    }

    def 'Testing no crash'(){
        given:
        arena.setDonkeyKong(new DonkeyKong(1,1))
        arena.fireMonsters.add(new Fire(2,2))
        when:
        def crash = new Crash(new Position(3,3), arena)
        then:
        !crash.isValid()
    }

}
