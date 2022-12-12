package com.aor.DK.model.elements

import spock.lang.Specification

class MarioTest extends Specification{
    Mario mario

    def setup(){
        mario = new Mario(1,1)
    }

    def 'Testing Mario get/set Vy'(){
        when:
        mario.setVy(2)
        then:
        mario.getVy() == 2
    }

    def 'Testing increment Vy < 2'(){
        when:
        mario.setVy(1)
        mario.incrementVy(3)
        then:
        mario.getVy() == 4
    }

    def 'Testing increment Vy with Vy > 2'(){
        when:
        mario.setVy(2)
        mario.incrementVy(3)
        then:
        mario.getVy() == 2
    }

    def 'Testing stationary right'(){
        when:
        mario.stationaryRight()
        then:
        mario.getLetter() == ',' as char
    }

    def 'Testing stationary left'(){
        when:
        mario.stationaryLeft()
        then:
        mario.getLetter() == '-' as char
    }

    def 'Testing running left'(){
        when:
        mario.runningLeft()
        then:
        mario.getLetter() == '.' as char
    }

    def 'Testing running right'(){
        when:
        mario.runningRight()
        then:
        mario.getLetter() == '*' as char
    }

    def 'Testing going up'(){
        when:
        mario.goingUp()
        then:
        mario.getLetter() == '/' as char
    }

    def 'Testing going up 2'(){
        when:
        mario.goingUp2()
        then:
        mario.getLetter() == ':' as char
    }

    def 'Testing moving right when stationary'(){
        given:
        mario.setLetter(',' as char)
        when:
        mario.movingRight();
        then:
        mario.letter == '*' as char
    }

    def 'Testing moving right when running'(){
        given:
        mario.setLetter('*' as char)
        when:
        mario.movingRight();
        then:
        mario.letter == ',' as char
    }

    def 'Testing moving left when stationary'(){
        given:
        mario.setLetter('-' as char)
        when:
        mario.movingLeft();
        then:
        mario.letter == '.' as char
    }

    def 'Testing moving left when running'(){
        given:
        mario.setLetter('.' as char)
        when:
        mario.movingLeft();
        then:
        mario.letter == '-' as char
    }

    def 'Testing climbing stairs when running'(){
        given:
        mario.setLetter('/' as char)
        when:
        mario.climbingStairs();
        then:
        mario.letter == ':' as char
    }

    def 'Testing climbing stairs'(){
        given:
        mario.setLetter('/' as char)
        when:
        mario.climbingStairs();
        then:
        mario.letter == ':' as char
    }

    def 'Testing climbing stairs 2'(){
        given:
        mario.setLetter(':' as char)
        when:
        mario.climbingStairs();
        then:
        mario.letter == '/' as char
    }

    def 'Testing stationary with stationary right'(){
        given:
        mario.setLetter('*' as char)
        when:
        mario.stationary();
        then:
        mario.letter == ',' as char
    }

    def 'Testing stationary with stationary left'(){
        given:
        mario.setLetter('.' as char)
        when:
        mario.stationary();
        then:
        mario.letter == '-' as char
    }

    def 'Testing stationary with stationary left'(){
        given:
        mario.setLetter('/' as char)
        when:
        mario.stationary();
        then:
        mario.letter == ',' as char
    }




}
