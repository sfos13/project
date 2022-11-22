package com.aor.DK.Viewer;

import com.aor.DK.gui.GUI;
import com.aor.DK.model.elements.Floor;

public class FloorViewer implements GenericViewer<Floor> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}
