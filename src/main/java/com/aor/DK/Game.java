package com.aor.DK;

import com.aor.DK.GUI.LanternaGUI;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;
import com.aor.DK.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(41, 31);
        this.state = new MenuState(new Menu("Start"));
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 20;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                return;
            }
        }
        gui.close();
    }
}
