package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.viewer.menu.InstructionsViewer;
import com.aor.DK.viewer.menu.LostViewer;
import com.aor.DK.viewer.menu.StartViewer;
import com.aor.DK.viewer.menu.WinViewer;

import java.io.IOException;



public class MenuViewer extends Viewer<Menu> {
    String message = getModel().getMessage();
    Menu menu;

    public MenuViewer(Menu menu) {
        super(menu);
        this.menu = menu;
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        int y = 5;
        int w = 40;
        int x = (w - message.length()) / 2;
        gui.drawText(new Position(x, y), message, "#efa107");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            x = (w - getModel().getEntry(i).length()) / 2;
            gui.drawText(new Position(x, y + 2 + i * 2), getModel().getEntry(i), getModel().isSelectedNumber(i) ? "#E6003C" : "#FFFFFF");
        }

        if (getModel().getMod().equals("Instructions")) {
            InstructionsViewer instruct = new InstructionsViewer(menu);
            instruct.drawElements(gui);
        }

        if (getModel().getMod().equals("Ranking")) {
            RankingViewer rankingViewer = new RankingViewer(new Ranking());
            rankingViewer.drawElements(gui);
        }

        if (getModel().getMod().equals("Lost")) {
            LostViewer lost = new LostViewer(menu);
            lost.drawElements(gui);
        }
        if (getModel().getMod().equals("Start")) {
            StartViewer start = new StartViewer(menu);
            start.drawElements(gui);
        }
        if (getModel().getMod().equals("Win")) {
            WinViewer win = new WinViewer(menu);
            win.drawElements(gui);
        }

    }

}