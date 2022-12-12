package com.aor.DK.model.ranking;

import java.io.Serializable;

public class RankingElement implements Serializable, Comparable<RankingElement> {

    String name;
    int score;

    public RankingElement(String name, int score) {
        this.name = name.toUpperCase();
        this.score = score;
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
    public int compareTo(RankingElement o) {
        return score - o.score;
    }
}