package com.aor.DK.viewer

import com.aor.DK.model.menu.Menu
import spock.lang.Specification

class MenuViewerTest extends Specification{

    def 'Testing draw elements' (){
        given:
        def viewer = new MenuViewer(new Menu("Instructions"))
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        when:
        viewer.drawElements(gui)
        then:
        _ * gui.drawText(_,_,_)

    }

}
