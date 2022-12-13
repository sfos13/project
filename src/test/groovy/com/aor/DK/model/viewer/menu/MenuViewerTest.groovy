package com.aor.DK.model.viewer.menu

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.Position
import com.aor.DK.model.menu.Menu
import spock.lang.Specification

class MenuViewerTest extends Specification{

    def 'Testing instructions viewer'(){
        given:
        def viewer = new InstructionsViewer(new Menu("Instructions"))
        def gui = Mock(LanternaGUI.class, constructorArgs:[30,30])
        when:
        viewer.drawElements(gui)
        then:
        1 * gui.drawText(new Position(5,20),"-Space is to jump","#FFFFFF");
        1 * gui.drawText(new Position(5,22),"-Pay attention to the monsters ","#FFFFFF");
    }

    def 'Testing lost viewer'(){
        given:
        def viewer = new LostViewer(new Menu("Lost"))
        def gui = Mock(LanternaGUI.class, constructorArgs:[30,30])
        when:
        viewer.drawElements(gui)
        then:
        1 * gui.drawDonkeyKong(new Position(19, 24));
    }

}
