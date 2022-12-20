package com.aor.DK.viewer.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.MenuViewer;

public class InstructionsViewer extends MenuViewer {
    public InstructionsViewer(Menu menu) {
        super(menu);
    }

    public void drawElements(GUI gui) {
        int x = 2;
        int y = 12;
        gui.drawText(new Position(x + 2, y), "Princess", "#E6003C");
        gui.drawText(new Position(x + 2, y + 1), "Your goal is to save her ", "#FFFFFF");
        gui.drawPrincess(new Position(x, y));

        gui.drawText(new Position(x + 2, y + 3), "Donkey Kong ", "#E6003C");
        gui.drawText(new Position(x + 2, y + 4), "Appears in every level ", "#FFFFFF");
        gui.drawText(new Position(x + 2, y + 5), "Throwing obstacles or guarding Lady ", "#FFFFFF");
        gui.drawDonkeyKong(new Position(x, y + 3));

        gui.drawText(new Position(x + 2, y + 7), "Stairs", "#E6003C");
        gui.drawText(new Position(x + 2, y + 8), "To go to the up level", "#FFFFFF");
        gui.drawText(new Position(x + 2, y + 9), "you need to climb them", "#FFFFFF");
        gui.drawStair(new Position(x, y + 7));
        gui.drawStair(new Position(x, y + 8));

        gui.drawText(new Position(x + 2, y + 11), "Barrels", "#E6003C");
        gui.drawText(new Position(x + 2, y + 12), "Are thrown by Donkey Kong", "#FFFFFF");
        gui.drawText(new Position(x + 2, y + 13), "Move randomly across the game", "#FFFFFF");
        gui.drawText(new Position(x + 2, y + 14), "Jump them to get some points", "#FFFFFF");
        gui.drawBarrel(new Position(x, y + 11));

    }

}