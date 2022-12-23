package com.aor.DK.controller.game;

import com.aor.DK.controller.Controller;
import com.aor.DK.model.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
