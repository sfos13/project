package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.DonkeyKong;
import com.aor.DK.viewer.GenericViewer;


public class DonkeyKongViewer implements GenericViewer<DonkeyKong> {
    @Override
    public void draw(DonkeyKong donkeyKong, GUI gui) {
        gui.drawDonkeyKong(donkeyKong.getPosition());
    }
}
