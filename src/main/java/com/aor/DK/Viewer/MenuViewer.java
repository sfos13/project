package com.aor.DK.Viewer;
import com.aor.DK.GUI.GUI;
import com.aor.DK.model.Position;
import com.aor.DK.model.menu.Menu;



public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }
    @Override
    public void drawElements(GUI gui) {

        String message=getModel().getMessage();
        int y=10;
        int w=40;
        int x;
        x= (w-message.length())/2;
        gui.drawText(new Position(x, y), message, "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            x=(w-getModel().getEntry(i).length())/2;
            gui.drawText(new Position(x, y + 2 + i), getModel().getEntry(i), getModel().isSelected_Number(i) ? "#FFD700" : "#FFFFFF");
        }
    }

}
