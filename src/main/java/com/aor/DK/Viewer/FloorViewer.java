package com.aor.DK.Viewer;

import com.aor.DK.gui.GUI;
import com.aor.DK.model.game.elements.Floor;

public class FloorViewer implements GenericViewer<Wall> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}
