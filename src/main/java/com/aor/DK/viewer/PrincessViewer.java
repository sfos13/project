<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/PrincessViewer.java
package com.aor.DK.viewer.elements;
========
package com.aor.DK.viewer;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/PrincessViewer.java

import com.aor.DK.GUI.GUI;

import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Princess;


public class PrincessViewer implements GenericViewer<Princess> {
    @Override
    public void draw(Princess princess, GUI gui) {
        gui.drawPrincess(princess.getPosition());
    }
}
