package com.aor.DK;

import java.io.IOException;

public class Game {
    private State state;
    private final LanternaGUI gui;

    public Game() throws IOException {
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
            state.update
            state.step(this, gui, startTime);
        }
        gui.close();
    }
}
