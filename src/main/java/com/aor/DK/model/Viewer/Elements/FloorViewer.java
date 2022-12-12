<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/FloorViewer.java
package com.aor.DK.viewer;
========
package com.aor.DK.Viewer.Elements;
>>>>>>>> refactor:src/main/java/com/aor/DK/viewer/Elements/FloorViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.elements.Floor;

public class FloorViewer implements GenericViewer<Floor> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}
