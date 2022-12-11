package com.aor.DK.GUI;

import com.aor.DK.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface GUI {

    List<ACTION> getNextActions() throws IOException;

    void drawMario(Position position, char letter);

    void drawDonkeyKong(Position position);

    void drawPrincess(Position position);

    void drawFloor(Position position);

    void drawBarrel(Position position);

    void drawStair(Position position);

    void drawText(Position position, String text, String color);


    void drawScores(Position position, int highScore, int bonusScore, int jumpScore);

    void drawLevel(Position position, int level) ;



    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, QUIT, SPACE, SELECT}
}
