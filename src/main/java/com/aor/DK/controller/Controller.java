package com.aor.DK.controller;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;

}