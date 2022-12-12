
package com.aor.DK.model.Viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Floor;

public class FloorViewer implements GenericViewer<Floor> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}