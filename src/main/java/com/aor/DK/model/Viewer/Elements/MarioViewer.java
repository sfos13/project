<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/MarioViewer.java
package com.aor.DK.viewer;
========
package com.aor.DK.Viewer.Elements;
>>>>>>>> refactor:src/main/java/com/aor/DK/viewer/Elements/MarioViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.elements.Mario;



    public class MarioViewer implements GenericViewer<Mario> {
        @Override
        public void draw(Mario mario, GUI gui) {
            gui.drawMario(mario.getPosition(), mario.getLetter());
        }
    }

