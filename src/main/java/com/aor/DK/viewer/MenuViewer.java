package com.aor.DK.Viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.Menu.LostViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.Menu.InstructionsViewer;


public class MenuViewer extends Viewer<Menu> {
    String message=getModel().getMessage();
    Menu menu;
    public MenuViewer(Menu menu) {
        super(menu);
        this.menu=menu;
    }
    @Override
    public void drawElements(GUI gui) {
        int y=10;
        int w=40;
        int x=(w-message.length())/2;
        gui.drawText(new Position(x, y), message, "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            x=(w-getModel().getEntry(i).length())/2;
            gui.drawText(new Position(x, y + 2 + i*2), getModel().getEntry(i), getModel().isSelected_Number(i) ? "#FFD700" : "#FFFFFF");
        }

        if (getModel().getMod().equals("Instructions")){
            InstructionsViewer instruct = new InstructionsViewer(menu);
            instruct.drawElements(gui);
        }

        if (getModel().getMod().equals("Lost")){
            LostViewer lost = new LostViewer(menu);
            lost.drawElements(gui);
        }

    }

}
