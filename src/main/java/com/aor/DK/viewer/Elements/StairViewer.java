<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/StairViewer.java
package com.aor.DK.viewer;
========
package com.aor.DK.Viewer.Elements;
>>>>>>>> d98772f5993f000732dd114a3f52a83243914e85:src/main/java/com/aor/DK/viewer/Elements/StairViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.elements.Stair;

public class StairViewer implements GenericViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(stair.getPosition());
    }
}
