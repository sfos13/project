package com.aor.DK.controller

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.controller.game.ArenaController
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Mario
import spock.lang.Specification

class ArenaControllerTest extends Specification{

    def 'testing step'(){
        given:
        def game = Mock(Game.class)
        def arena = Mock(Arena.class, constructorArgs:[10, 10])
        def arenaController = new ArenaController(arena)
        def guiList = new ArrayList<GUI.ACTION>()
        arena.getMario().getPosition() >> new Position(1,1)
        guiList.add(GUI.ACTION.QUIT)
        when:
        arenaController.step(game, guiList,0)
        then:
        1 * game.setState(_);
   }

}
