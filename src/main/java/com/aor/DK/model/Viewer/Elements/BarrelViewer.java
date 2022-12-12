<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/BarrelViewer.java
package com.aor.DK.viewer;
========
package com.aor.DK.Viewer.Elements;
>>>>>>>> refactor:src/main/java/com/aor/DK/viewer/Elements/BarrelViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.elements.Barrel;

    public class BarrelViewer implements GenericViewer<Barrel> {
        @Override
        public void draw(Barrel barrel, GUI gui) {
            gui.drawBarrel(barrel.getPosition());
        }
    }

