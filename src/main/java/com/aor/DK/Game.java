package com.aor.DK;

import com.aor.DK.GUI.LanternaGUI;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;
import com.aor.DK.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private State state;
    private final LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        while(this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
        }
        gui.close();
    }
}