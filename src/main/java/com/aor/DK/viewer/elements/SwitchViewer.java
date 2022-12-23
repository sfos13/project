package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Switch;
import com.aor.DK.viewer.GenericViewer;

public class SwitchViewer implements GenericViewer<Switch> {
    @Override
    public void draw(Switch s, GUI gui) {
        if (s.isOn()) {
            gui.drawSwitch(s.getPosition(), "#fff600");
        } else {
            gui.drawSwitch(s.getPosition(), "#00FF00");
        }
    }
}
