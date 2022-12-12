package com.aor.DK.model.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Mario;

    public class MarioViewer implements GenericViewer<Mario> {
        @Override
        public void draw(Mario mario, GUI gui) {
            gui.drawMario(mario.getPosition(), mario.getLetter());
        }
    }

