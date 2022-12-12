
<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/FloorViewer.java
package com.aor.DK.viewer.elements;
========
package com.aor.DK.viewer;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/FloorViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Floor;

public class FloorViewer implements GenericViewer<Floor> {
    @Override
    public void draw(Floor floor, GUI gui) {
        gui.drawFloor(floor.getPosition());
    }
}