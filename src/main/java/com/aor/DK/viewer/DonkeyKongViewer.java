<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/elements/DonkeyKongViewer.java
package com.aor.DK.viewer.elements;
========
package com.aor.DK.viewer;
>>>>>>>> cd13d82edde057efec67aecf9b200967830fa8dd:src/main/java/com/aor/DK/viewer/DonkeyKongViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.DonkeyKong;


public class DonkeyKongViewer implements GenericViewer<DonkeyKong> {

    public void draw(DonkeyKong donkeyKong, GUI gui) {
        gui.drawDonkeyKong(donkeyKong.getPosition());
    }
}
