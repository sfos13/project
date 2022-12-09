package com.aor.DK.viewer.Menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.viewer.MenuViewer;

public class InstructionsViewer extends MenuViewer {

    public InstructionsViewer(Menu menu) {
            super(menu);
    }
    public void drawElements(GUI gui){
        gui.drawText(new Position(5,20),"-Space is to jump","#FFFFFF");
        gui.drawText(new Position(5,22),"-Pay attention to the monsters ","#FFFFFF");

        }

    }

