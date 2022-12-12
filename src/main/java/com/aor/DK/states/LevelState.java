package com.aor.DK.states;

import com.aor.DK.model.viewer.LevelViewer;
import com.aor.DK.model.viewer.Viewer;
import com.aor.DK.controller.Controller;
import com.aor.DK.controller.menu.LevelController;
import com.aor.DK.model.menu.Level;


public class LevelState extends State<Level> {
    public LevelState(Level model) {
        super(model);
    }


    @Override
    public Viewer<Level> getViewer() {
        return new LevelViewer(getModel());
    }

    @Override
    public Controller<Level> getController() {
        return new LevelController(getModel());
    }

}
