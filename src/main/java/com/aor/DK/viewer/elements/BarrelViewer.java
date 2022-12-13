package com.aor.DK.viewer.elements;


import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Barrel;

    public class BarrelViewer implements GenericViewer<Barrel> {
        @Override
        public void draw(Barrel barrel, GUI gui) {
            gui.drawBarrel(barrel.getPosition());
        }
    }

