package com.aor.DK.model.menu;

import java.util.Arrays;

public class RegisterScoreMenu extends Menu {
    int score;

    public RegisterScoreMenu(String mod, int score) {
        super(mod);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    protected void parse(String mod) {
        if (mod.equals("Win")) {
            this.entries = Arrays.asList("Play Again?", "Register Score","Exit to Menu SPACE");
            this.message = "Congratulations! You won the game!";
        }
        if (mod.equals("Lost")) {
            this.entries = Arrays.asList("Play Again?", "Register Score","Exit to Menu SPACE");
            this.message = "Try again! Its just a Donkey Kong";
        }
    }
}
