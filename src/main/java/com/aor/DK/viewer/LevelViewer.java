package com.aor.DK.Viewer;


import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;

import com.aor.DK.model.menu.Level;
import com.aor.DK.model.ranking.Scores;


public class LevelViewer extends Viewer<Level> {

    public LevelViewer(Level level) {
        super(level);
    }


    @Override
    public void drawElements(GUI gui) {
        String message = "How High Can You Go?";
        int x = (40 - message.length()) / 2;
        int y = 28;
        int level = getModel().getLevel();

        gui.drawLevel(new Position(36,1),level);
        gui.drawScores(new Position(1,1),0,0);
        gui.drawText(new Position(x,y),"HOW HIGH CAN YOU GET?","#FFFFFF" );

        gui.drawDonkeyKong(new Position(20, y -4));
        gui.drawText(new Position(5, y -3),   "25 m", "#FFFFFF");

        if (level==2) {
            gui.drawDonkeyKong(new Position(20, y - 8));
            gui.drawText(new Position(5, y - 7), "50 m", "#FFFFFF");
        }

    }


}
