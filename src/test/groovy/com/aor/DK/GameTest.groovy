import com.aor.DK.Game
import spock.lang.Specification

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.states.MenuState
import com.aor.DK.states.State


class GameTest extends Specification {
    private Game game
    private LanternaGUI gui

    def setup() {
        gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        game = new Game()
    }

    def "test game object is not null"() {
        expect:
        game != null
    }

    def "test setState method"() {
        when:
        game.setState(null)

        then:
        game.state == null
    }

}
