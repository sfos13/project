package com.aor.DK.states;


import com.aor.DK.model.Viewer.GameViewer;
import com.aor.DK.Viewer.Viewer;
import com.aor.DK.controller.Controller;
import com.aor.DK.controller.game.ArenaController;
import com.aor.DK.model.arena.Arena;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    public Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    public Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}