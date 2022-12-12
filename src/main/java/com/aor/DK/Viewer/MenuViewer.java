package com.aor.DK.Viewer;

<<<<<<< HEAD:src/main/java/com/aor/DK/viewer/MenuViewer.java
package com.aor.DK.viewer;

=======
package com.aor.DK.Viewer;
>>>>>>> refactor:src/main/java/com/aor/DK/Viewer/MenuViewer.java
import com.aor.DK.GUI.GUI;
import com.aor.DK.Viewer.Menu.InstructionsViewer;
import com.aor.DK.Viewer.Menu.LostViewer;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;



public class MenuViewer extends Viewer<Menu> {
    String message=getModel().getMessage();
    String mod = getModel().getMod();
    Menu menu;
    public MenuViewer(Menu menu) {
        super(menu);
        this.menu=menu;
    }
    @Override
    public void drawElements(GUI gui) {
        int y=10;
        int w=40;
        int x=(w-message.length())/2;


        gui.drawText(new Position(x, y), message, "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            x=(w-getModel().getEntry(i).length())/2;
            gui.drawText(new Position(x, y + 2 + i*2), getModel().getEntry(i), getModel().isSelected_Number(i) ? "#FFD700" : "#FFFFFF");
        }

        drawInstructions(gui);
        drawLost(gui);

    }

    private void drawInstructions(GUI gui) {
        if (mod.equals("Instructions")){
            InstructionsViewer instruct = new InstructionsViewer(menu);
            instruct.drawElements(gui);
        }
    }

    private void drawLost(GUI gui) {
        if (mod.equals("Lost")){
            LostViewer lost = new LostViewer(menu);
            lost.drawElements(gui);
        }
    }

}
