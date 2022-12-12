package com.aor.DK.model.Viewer;

import com.aor.DK.GUI.GUI;

import com.aor.DK.model.elements.Princess;


public class PrincessViewer implements GenericViewer<Princess> {
    @Override
    public void draw(Princess princess, GUI gui) {
        gui.drawPrincess(princess.getPosition());
    }
}
