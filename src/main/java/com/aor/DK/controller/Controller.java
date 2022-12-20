package com.aor.DK.controller;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;

import java.io.IOException;
import java.util.List;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, List<GUI.ACTION> actions, long time) throws IOException, InterruptedException;

}