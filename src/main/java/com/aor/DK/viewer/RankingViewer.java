package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.model.ranking.RankingElement;
import com.aor.DK.viewer.Viewer;

import java.util.List;

public class RankingViewer extends Viewer<Ranking> {

    Ranking ranking;

    List<RankingElement> list;


    public RankingViewer(Ranking model) {
        super(model);
        this.ranking = model;
        list = ranking.getList();
    }


    @Override
    public void drawElements(GUI gui) {
        int w = 40;
        String message = "Ranking";
        int x = (w - message.length()) / 2;
        gui.drawText(new Position(x, 3), message, "#E6003C");

        gui.drawText(new Position(x - 10, 6), "Name", "#ffffff");
        gui.drawText(new Position(x + 10, 6), "Total Score", "#ffffff");
        int y = 9;
        for (RankingElement element : list) {
            gui.drawText(new Position(x - 10, y), element.getName(), "#13EBD9");
            gui.drawText(new Position(x + 12, y), String.valueOf(element.getScore()), "#13EBD9");

            y += 2;

        }
        String finalMessage = "Exit SPACE";
        int x1 = (w - finalMessage.length()) / 2;
        gui.drawText(new Position(x1, 30), finalMessage, "#E6003C");

    }
}