package com.aor.DK.Viewer;

import com.aor.DK.gui.GUI;
import com.aor.DK.model.game.elements.Element;

public interface GenericViewer {

    public interface ElementViewer<T extends Element> {
        void draw(T element, GUI gui);
    }
}
