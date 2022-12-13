package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.ranking.Ranking;;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.ranking.RankingViewer;
import com.aor.DK.viewer.menu.InstructionsViewer;
import com.aor.DK.viewer.menu.LostViewer;

import java.io.IOException;


public class MenuViewer extends Viewer<Menu> {
    String message=getModel().getMessage();
    Menu menu;
    public MenuViewer(Menu menu) {
        super(menu);
        this.menu=menu;
    }
    @Override
    public void drawElements(GUI gui) throws IOException {
        int y=10;
        int w=40;
        int x=(w-message.length())/2;
        gui.drawText(new Position(x, y), message, "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            x=(w-getModel().getEntry(i).length())/2;
            gui.drawText(new Position(x, y + 2 + i*2), getModel().getEntry(i), getModel().isSelected_Number(i) ? "#E6003C" : "#FFFFFF");
        }

        if (getModel().getMod().equals("Instructions")){
            InstructionsViewer instruct = new InstructionsViewer(menu);
            instruct.drawElements(gui);
        }

        if(getModel().getMod().equals("Ranking")) {
            RankingViewer rankingViewer = new RankingViewer(new Ranking());
            rankingViewer.drawElements(gui);
        }

        if (getModel().getMod().equals("Lost")){
            LostViewer lost = new LostViewer(menu);
            lost.drawElements(gui);
        }

    }

}
