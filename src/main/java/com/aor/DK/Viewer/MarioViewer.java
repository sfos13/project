package com.aor.DK.viewer;

<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/Elements/MarioViewer.java
package com.aor.DK.Viewer.Elements;
========
package com.aor.DK.viewer;
>>>>>>>> 5390dce126dfe5973a39985df3be6574adf424a4:src/main/java/com/aor/DK/viewer/MarioViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.elements.Mario;



    public class MarioViewer implements GenericViewer<Mario> {
        @Override
        public void draw(Mario mario, GUI gui) {
            gui.drawMario(mario.getPosition(), mario.getLetter());
        }
    }

