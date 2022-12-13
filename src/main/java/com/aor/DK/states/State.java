package com.aor.DK.states;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.controller.Controller;
import com.aor.DK.viewer.Viewer;

import java.io.IOException;
import java.util.List;

public abstract class State<T> {
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    private T model;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }


    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public void step(Game game, GUI gui, long time) throws IOException, InterruptedException {
        viewer.draw(gui);
        List<GUI.ACTION> actions = gui.getNextActions();
        controller.step(game, actions, time);
    }
}
