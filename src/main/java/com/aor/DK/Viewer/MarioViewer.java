package com.aor.DK.Viewer;
import com.aor.DK.gui.GUI;
import com.aor.DK.model.game.elements.Hero;

public class MarioViewer {

    public class MarioViewer implements GenericViewer<Mario> {
        @Override
        public void draw(Mario mario, GUI gui) {
            gui.drawMario(Mario.getPosition());
        }
    }
}
