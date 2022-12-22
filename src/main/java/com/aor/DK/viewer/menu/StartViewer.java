package com.aor.DK.viewer.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.MenuViewer;

public class StartViewer extends MenuViewer implements MenuGeneric {
    public StartViewer(Menu menu) {
        super(menu);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawDonkeyKong(new Position(15, 20));
        gui.drawPrincess(new Position(20, 20));
        gui.drawText(new Position(21, 20), "HELP!!!!", "#EB93D0");

    }
}