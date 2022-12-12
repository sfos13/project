
package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Floor;

public class FloorViewer implements GenericViewer<Floor> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}