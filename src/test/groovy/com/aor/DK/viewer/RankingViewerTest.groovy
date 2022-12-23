package com.aor.DK.viewer

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.ranking.Ranking
import com.aor.DK.viewer.RankingViewer
import spock.lang.Specification

class RankingViewerTest extends Specification{
    def 'Testing ranking viewer draw'(){
        given:
        def ranking = new Ranking()
        def viewer = new RankingViewer(ranking)
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        when:
        viewer.draw(gui)
        then:
        _ * gui.drawText(_)
    }
}
