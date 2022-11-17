package com.aor.DK.Viewer;

import com.aor.DK.gui.GUI;
import com.aor.DK.model.game.elements.Barrel;

    public class BarrelViewer implements GenericViewer<Barrel> {
        @Override
        public void draw(Barrel barrel, GUI gui) {
            gui.drawBarrel(barrel.getPosition());
        }
    }
}
