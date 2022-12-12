package com.aor.DK.model.ranking;

import java.io.Serializable;
import java.util.Comparator;

public class RankingElement implements Serializable, Comparator<RankingElement> {

    String name;
    int score;

    public RankingElement(String name, int scoreJump, int scoreTime) {
        this.name = name.toUpperCase();
        this.score = scoreJump + scoreTime;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int compare(RankingElement p, RankingElement p1) {
        return Integer.compare(p1.score, p.score);
    }
}