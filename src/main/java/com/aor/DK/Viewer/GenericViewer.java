package com.aor.DK.Viewer;

import com.aor.DK.gui.GUI;
import com.aor.DK.model.elements.Element;


    public interface GenericViewer<T extends Element> {
        void draw(T element, GUI gui);
    }

