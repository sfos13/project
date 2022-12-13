package com.aor.DK.viewer.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.MenuViewer;

public class WinViewer extends MenuViewer implements MenuGeneric {
    public WinViewer(Menu menu) {
        super(menu);
    }

    public void drawElements(GUI gui) {
        gui.drawPrincess(new Position(20,20));}
}