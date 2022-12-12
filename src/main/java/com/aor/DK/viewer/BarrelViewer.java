<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/BarrelViewer.java
package com.aor.DK.viewer.elements;
========
package com.aor.DK.viewer;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/BarrelViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Barrel;

    public class BarrelViewer implements GenericViewer<Barrel> {
        @Override
        public void draw(Barrel barrel, GUI gui) {
            gui.drawBarrel(barrel.getPosition());
        }
    }

