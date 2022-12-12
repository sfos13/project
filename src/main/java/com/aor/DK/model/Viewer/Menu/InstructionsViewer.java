package com.aor.DK.model.Viewer.Menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Viewer.MenuViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;


public class InstructionsViewer extends MenuViewer {

    public InstructionsViewer(Menu menu) {
            super(menu);
    }
    public void drawElements(GUI gui){
        gui.drawText(new Position(5,20),"-Space is to jump","#FFFFFF");
        gui.drawText(new Position(5,22),"-Pay attention to the monsters ","#FFFFFF");

        }

    }

