package com.aor.DK.viewer;

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.elements.*;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.*;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, GenericViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, GenericViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    @Override
    public void drawElements(GUI gui) {

        List<List<Floor>> floor = getModel().getFloor();
        for(List<Floor> storey : floor) {
            drawElements(gui, storey, new FloorViewer());
        }

        List<Stair> stairs = getModel().getStairs();
        drawElements(gui, stairs, new StairViewer());

        List<Barrel> barrels = getModel().getBarrels();
        drawElements(gui, barrels, new BarrelViewer());

        Mario mario = getModel().getMario();
        drawElement(gui, mario, new MarioViewer());

        DonkeyKong donkeyKong = getModel().getDonkeyKong();
        drawElement(gui, donkeyKong, new DonkeyKongViewer());

        Princess princess = getModel().getPrincess();
        drawElement(gui, princess, new PrincessViewer());

    }


}
