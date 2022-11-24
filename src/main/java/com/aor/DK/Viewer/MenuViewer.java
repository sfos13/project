package com.aor.DK.Viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;


public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }
    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(30, 10), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(30, 14 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
