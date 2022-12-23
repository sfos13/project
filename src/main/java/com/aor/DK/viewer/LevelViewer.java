package com.aor.DK.viewer;


import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Level;

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
        String white = "#FFFFFF";
        String blue = "#3F50EB";
        gui.drawText(new Position(x, y), message, white);
        gui.drawText(new Position(30, 5), "L=" + level, blue);

        gui.drawDonkeyKong(new Position(20, y - 4));
        gui.drawText(new Position(5, y - 3), "25 m", white);

        drawLevel2(gui, y, level, white);

    }

    private void drawLevel2(GUI gui, int y, int level, String colour) {
        if (level == 2) {
            gui.drawDonkeyKong(new Position(20, y - 8));
            gui.drawText(new Position(5, y - 7), "50 m", colour);
        }
    }


}
