<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/FireViewer.java
package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.Viewer.GenericViewer;
========
package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/FireViewer.java
import com.aor.DK.model.elements.Fire;

public class FireViewer implements GenericViewer<Fire> {
    @Override
    public void draw(Fire fire, GUI gui) {
        gui.drawFire(fire.getPosition(), fire.getLetter());
    }
}
