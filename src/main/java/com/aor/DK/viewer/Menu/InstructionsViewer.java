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
        int x = 8;
        int y=10;
        gui.drawMario(new Position(x,y), '@');
        gui.drawDonkeyKong(new Position(x,y+3));
        gui.drawBarrel(new Position(x,y+6));
        gui.drawFire(new Position(x,y+9),'@');
        gui.drawPrincess(new Position(x,y+12));
        gui.drawStair(new Position(x,y+15));
        gui.drawStair(new Position(x,y+16));}

}

