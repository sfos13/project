<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/MarioViewer.java
package com.aor.DK.viewer.elements;
========
package com.aor.DK.viewer;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/MarioViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Mario;

    public class MarioViewer implements GenericViewer<Mario> {
        @Override
        public void draw(Mario mario, GUI gui) {
            gui.drawMario(mario.getPosition(), mario.getLetter());
        }
    }

