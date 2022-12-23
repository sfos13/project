package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Stair;
import com.aor.DK.viewer.GenericViewer;

public class StairViewer implements GenericViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(stair.getPosition());
    }
}
