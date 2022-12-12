package com.aor.DK.model.viewer.menu;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.viewer.MenuViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;


public class LostViewer extends MenuViewer {



    public LostViewer(Menu menu) {
        super(menu);
    }

    public void drawElements(GUI gui){
        gui.drawDonkeyKong(new Position(19, 24));
    }
}
