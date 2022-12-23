package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.viewer.GenericViewer;

public class MarioViewer implements GenericViewer<Mario> {
    @Override
    public void draw(Mario mario, GUI gui) {
        gui.drawMario(mario.getPosition(), mario.getLetter());
    }
}

