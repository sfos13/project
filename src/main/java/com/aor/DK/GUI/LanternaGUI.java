package com.aor.DK.GUI;


import com.aor.DK.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class LanternaGUI implements GUI {
    private final Screen screen;
    Set<Integer> pressedKeys = new HashSet<>();

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();

        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/MyFont-Modern.otf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }


    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }


    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        ((AWTTerminalFrame) terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });

        return terminal;
    }
    @Override
    public List<ACTION> getNextActions() throws IOException {
        List<ACTION> actions = new ArrayList<>();
        if (pressedKeys.contains(KeyEvent.VK_SPACE)) actions.add(ACTION.SPACE);
        if (pressedKeys.contains(KeyEvent.VK_Q)) actions.add(ACTION.QUIT);
        if (pressedKeys.contains(KeyEvent.VK_UP)) actions.add(ACTION.UP);
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) actions.add(ACTION.RIGHT);
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) actions.add(ACTION.DOWN);
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) actions.add(ACTION.LEFT);
        if (pressedKeys.contains(KeyEvent.VK_ENTER)) actions.add(ACTION.SELECT);
        if (pressedKeys.contains(KeyEvent.VK_W)) actions.add(ACTION.WIN);

        return actions;
    }

    @Override
    public void drawMario(Position position, char letter) {
        drawCharacter(position.getX(), position.getY(), letter, "#e2cbd2");
    }

    @Override
    public void drawFloor(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#b4076d");
    }

    @Override
    public void drawBarrel(Position position) {
        drawCharacter(position.getX(), position.getY(), '(', "#ef970f");
    }

    @Override
    public void drawStair(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#4ad5f6");
    }

    @Override
    public void drawDonkeyKong(Position position) {
        drawCharacter(position.getX() - 1, position.getY() - 1, '$', "#A03305");
        drawCharacter(position.getX(), position.getY() - 1, '%', "#A03305");
        drawCharacter(position.getX() - 1, position.getY(), '&', "#A03305");
        drawCharacter(position.getX(), position.getY(), '\'', "#A03305");
    }

    @Override
    public void drawPrincess(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#ff57ff");
    }

    @Override
    public void drawFire(Position position, char letter) {
        drawCharacter(position.getX(), position.getY(), letter, "#ff8b00");
    }

    @Override
    public void drawSwitch(Position position, String color) {
        drawCharacter(position.getX(), position.getY(), ')', color);
    }

    @Override
    public void drawStick(Position position) {
        drawCharacter(position.getX(), position.getY(), '|', "#FAA0A0");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }


    @Override
    public void drawLevel(Position position, int level) {
        while (level > 9) {
            level /= 10;
        }
        drawText(position, "L=" + level, "#3F50EB");

    }
    @Override
    public void drawScores(Position position, int jumpScore, int timeScore) {
        int x = position.getX();
        int y = position.getY();

        drawText(position, "Bonus", "#E6003C");
        drawText(new Position(x, y + 1), String.valueOf(timeScore), "#ffffff");
        drawText(new Position(x + 10, y), "Jump Score", "#E6003C");
        drawText(new Position(x + 10, y + 1), String.valueOf(jumpScore), "#ffffff");
    }


    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }


    public void close(Screen screen) throws IOException {
        screen.close();
    }

    public Screen getScreen() {
        return screen;
    }
}
