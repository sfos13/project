package com.aor.DK;

import com.aor.DK.GUI.LanternaGUI;

import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;
import com.aor.DK.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Game {
    private State state;
    private LanternaGUI gui;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu(Arrays.asList("Start", "Exit"),"Menu"));
        this.gui = new LanternaGUI(70, 30);
        this.state = new MenuState(new Menu(Arrays.asList("Start", "Exit"),"Menu"));
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}
