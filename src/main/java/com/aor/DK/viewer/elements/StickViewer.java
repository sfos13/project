package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Stick;
import com.aor.DK.viewer.GenericViewer;

public class StickViewer implements GenericViewer<Stick> {
    @Override
    public void draw(Stick stick, GUI gui) {
        gui.drawStick(stick.getPosition());
    }
}
