package com.aor.DK.model.menu;

public class Level {

    private final int level;
    private final int score;
    public Level(int level, int total){
        this.level=level;
        this.score = total;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}
