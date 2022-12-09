package com.aor.DK.Viewer;


import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Level;
import com.aor.DK.viewer.Viewer;

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
        String branco= "#FFFFFF";
        String azul="#3F50EB";
        gui.drawText(new Position(x, y), message, branco);
        gui.drawText(new Position (30,5),"L="+level,azul);

        gui.drawDonkeyKong(new Position(20, y -4));
        gui.drawText(new Position(5, y -3),   "25 m", branco);

        if (level==2) {
            gui.drawDonkeyKong(new Position(20, y - 8));
            gui.drawText(new Position(5, y - 7), "50 m", branco);
        }

    }


}
