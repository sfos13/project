package com.aor.DK.model.ranking;

public class Scores implements Observer{
    private int timeScore;
    private int jumpScore;
    private int attackScore;

    private String player;

    private Subject resultData;

    public Scores(String player, Subject resultData){
        this.player= player;
        this.resultData=resultData;
        this.resultData.registerObserver(this);
    }

    @Override
    public void update(int timeScore, int jumpScore, int attackScore) {
        this.timeScore = timeScore;
        this.jumpScore=jumpScore;
        this.attackScore=attackScore;
        //refresh
    }


}
