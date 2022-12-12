<<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/PrincessViewer.java
package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
========
package com.aor.DK.Viewer.Elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.GenericViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.elements.DonkeyKong;
>>>>>>>> refactor:src/main/java/com/aor/DK/viewer/Elements/PrincessViewer.java
import com.aor.DK.model.elements.Princess;

public class PrincessViewer implements GenericViewer<Princess> {
    @Override
    public void draw(Princess princess, GUI gui) {
        gui.drawPrincess(princess.getPosition());
    }
}
