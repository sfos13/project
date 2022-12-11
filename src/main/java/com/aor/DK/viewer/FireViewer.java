package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Fire;

public class FireViewer implements GenericViewer<Fire>{
    @Override
    public void draw(Fire fire, GUI gui) {
        gui.drawFire(fire.getPosition(), fire.getLetter());
    }
}
