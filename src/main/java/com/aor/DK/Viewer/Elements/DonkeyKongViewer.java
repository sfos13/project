package com.aor.DK.Viewer.Elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.elements.DonkeyKong;


public class DonkeyKongViewer implements GenericViewer<DonkeyKong> {

    public void draw(DonkeyKong donkeyKong, GUI gui) {
        gui.drawDonkeyKong(donkeyKong.getPosition());
    }
}
