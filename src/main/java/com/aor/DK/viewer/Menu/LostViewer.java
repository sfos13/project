package com.aor.DK.viewer.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.MenuViewer;

public class LostViewer extends MenuViewer {
    public LostViewer(Menu menu) {
        super(menu);
    }

    public void drawElements(GUI gui) {
        gui.drawDonkeyKong(new Position(20,20));
    }
}
