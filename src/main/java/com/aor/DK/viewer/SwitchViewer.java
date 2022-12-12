package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Switch;

public class SwitchViewer implements GenericViewer<Switch>{
    @Override
    public void draw(Switch s, GUI gui) {
        if(s.isOn()){
            gui.drawSwitch(s.getPosition(),"#fff600");
        }
        else if (!s.isOn()){
            gui.drawSwitch(s.getPosition(),"#00FF00");
        }
        }
}
