package com.aor.DK.model.Viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Viewer.GenericViewer;
import com.aor.DK.model.elements.Switch;

public class SwitchViewer implements GenericViewer<Switch> {
    @Override
    public void draw(Switch s, GUI gui) {
        if(s.isOn()) gui.drawSwitch(s.getPosition());
    }
}