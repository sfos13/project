package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Princess;
import com.aor.DK.viewer.GenericViewer;


public class PrincessViewer implements GenericViewer<Princess> {
    @Override
    public void draw(Princess princess, GUI gui) {
        gui.drawPrincess(princess.getPosition());
    }
}
