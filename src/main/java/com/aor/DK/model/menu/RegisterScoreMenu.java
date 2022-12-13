package com.aor.DK.model.menu;

import java.util.Arrays;

public class RegisterScoreMenu extends Menu{
    int score;
    public RegisterScoreMenu(String mod, int score) {
        super(mod);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    protected void parse(String mod){
        if (mod.equals("Win")) {
            this.entries = Arrays.asList("Play again?", "Register Score", "Exit to Menu");
            this.message = "Congratulations! You won the game!";
        }
        if (mod.equals("Lost")) {
            this.entries = Arrays.asList("New Game?", "Register Score", "Exit to Menu");
            this.message = "Try again! Its just a Donkey Kong";
        }
    }
}
