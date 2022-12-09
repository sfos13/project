package com.aor.DK.model.ranking;

import com.aor.DK.model.Position;

public class Scores implements Observer{
    private int timeScore;
    private int jumpScore;

    private String player;

    private Subject resultData;

    public Scores(String player, Subject resultData){
        this.player= player;
        this.resultData=resultData;
        this.resultData.registerObserver(this);
    }

    @Override
    public void update(int timeScore, int jumpScore) {
        this.timeScore = timeScore;
        this.jumpScore=jumpScore;
        System.out.println(jumpScore);
    }


}
