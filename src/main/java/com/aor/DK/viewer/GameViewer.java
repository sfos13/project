package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Element;
import com.aor.DK.model.elements.Floor;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        for(List<Floor> storey : getModel().getFloor()) {
            drawElements(gui, storey, new FloorViewer());
        }
        drawElements(gui, getModel().getStairs(), new StairViewer());
        drawElements(gui, getModel().getBarrels(), new BarrelViewer());
        drawElement(gui, getModel().getMario(), new MarioViewer());
        drawElement(gui, getModel().getDonkeyKong(), new DonkeyKongViewer());
        drawElement(gui, getModel().getPrincess(), new PrincessViewer());
        drawElements(gui, getModel().getFireMonsters(), new FireViewer());
        drawElements(gui, getModel().getSwitches(),new SwitchViewer());
        gui.drawLevel(new Position(36,1),1);
        gui.drawScores(new Position(0,1),getModel().getScores().getJumpScore(),getModel().getScores().getTimeScore());

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, GenericViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, GenericViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
