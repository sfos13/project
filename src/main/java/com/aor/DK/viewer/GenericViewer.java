package com.aor.DK.Viewer;


import com.aor.DK.GUI.GUI;
import com.aor.DK.model.elements.Element;


    public interface GenericViewer<T extends Element> {
        void draw(T element, GUI gui);
    }

