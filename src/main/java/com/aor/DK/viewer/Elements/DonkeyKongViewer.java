<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/DonkeyKongViewer.java
package com.aor.DK.viewer;
========
package com.aor.DK.Viewer.Elements;
>>>>>>>> d98772f5993f000732dd114a3f52a83243914e85:src/main/java/com/aor/DK/viewer/Elements/DonkeyKongViewer.java

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.elements.DonkeyKong;

public class DonkeyKongViewer implements GenericViewer<DonkeyKong> {

    public void draw(DonkeyKong donkeyKong, GUI gui) {
        gui.drawDonkeyKong(donkeyKong.getPosition());
    }
}
