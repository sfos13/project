package com.aor.DK.GUI

import com.aor.DK.model.Position
import spock.lang.Specification

import java.awt.event.KeyEvent

class GUITest extends Specification{

    LanternaGUI lanternaGUI

    def setup(){
        lanternaGUI = new LanternaGUI(30,30)
    }

    def 'testing next action space'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_SPACE)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.SPACE)
    }

    def 'testing next action quit'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_Q)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.QUIT)
    }

    def 'testing next action up'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_UP)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.UP)
    }

    def 'testing next action down'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_DOWN)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.DOWN)
    }


    def 'testing next action left'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_LEFT)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.LEFT)
    }

    def 'testing next action right'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_RIGHT)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.RIGHT)
    }

    def 'testing next action enter'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_ENTER)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.SELECT)
    }

    def 'testing next action cheat win'(){
        given:
        lanternaGUI.pressedKeys.add(KeyEvent.VK_W)
        when:
        def nextActions =lanternaGUI.getNextActions()
        then:
        nextActions.contains(GUI.ACTION.WIN)
    }

    def 'Testing draw mario'(){
        when:
        lanternaGUI.drawMario(new Position(1,1), 'M' as char)
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == 'M' as char
    }

    def 'Testing draw floor'(){
        when:
        lanternaGUI.drawFloor(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '#' as char
    }

    def 'Testing draw barrel'(){
        when:
        lanternaGUI.drawBarrel(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '(' as char
    }

    def 'Testing draw stair'(){
        when:
        lanternaGUI.drawStair(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '+' as char
    }

    def 'Testing draw donkey kong'(){
        when:
        lanternaGUI.drawDonkeyKong(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(0,1).character == '$' as char
        lanternaGUI.getScreen().getBackCharacter(1,1).character == '%' as char
        lanternaGUI.getScreen().getBackCharacter(0,2).character == '&' as char
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '\'' as char
    }

    def 'Testing draw princess'(){
        when:
        lanternaGUI.drawPrincess(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '@' as char
    }

    def 'Testing draw fire'(){
        when:
        lanternaGUI.drawFire(new Position(1,1),'F' as char)
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == 'F' as char
    }

    def 'Testing draw switch'(){
        when:
        lanternaGUI.drawSwitch(new Position(1,1), "green")
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == ')' as char
    }

    def 'Testing draw stick'(){
        when:
        lanternaGUI.drawStick(new Position(1,1))
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '|' as char
    }

    def 'Testing draw text'(){
        when:
        lanternaGUI.drawText(new Position(1,1),"M","green")
        then:
        lanternaGUI.getScreen().getBackCharacter(1,1).character == 'M' as char
    }

    def 'Testing draw level'() {
        when:
        lanternaGUI.drawLevel(new Position(1, 1), 1)
        then:
        lanternaGUI.getScreen().getBackCharacter(1, 1).character == 'L' as char
        lanternaGUI.getScreen().getBackCharacter(2, 1).character == '=' as char
        lanternaGUI.getScreen().getBackCharacter(3, 1).character == '1' as char
    }

    def 'Testing draw score'(){
        when:
        lanternaGUI.drawScores(new Position(1,1),1,1)
        then:
        lanternaGUI.getScreen().getBackCharacter(1,2).character == '1' as char
        lanternaGUI.getScreen().getBackCharacter(11,1).character == 'J' as char
        lanternaGUI.getScreen().getBackCharacter(11,2).character == '1' as char
    }

    def 'Testing screen clear'(){
        when:
        lanternaGUI.drawText(new Position(1,1),"M","green")
        lanternaGUI.clear()
        then:
        lanternaGUI.getScreen().getBackCharacter(1,1).character == " " as char
    }

    def 'Testing screen refresh'(){
        when:
        lanternaGUI.drawText(new Position(1,1),"M","green")
        lanternaGUI.refresh()
        then:
        lanternaGUI.getScreen().getFrontCharacter(1,1).character == "M" as char
    }

    def 'Testing screen close'(){
        when:
        lanternaGUI.close()
        then:
        lanternaGUI.screen.close()
    }
}
