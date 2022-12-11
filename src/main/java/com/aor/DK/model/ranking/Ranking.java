package com.aor.DK.model.ranking;

public class Ranking implements Observer{
    private int timeScore;
    private int jumpScore;

    private String player;

    private Subject resultData;

    public Ranking(String player, Subject resultData){
        this.player= player;
        this.resultData=resultData;
        this.resultData.registerObserver(this);

    }


    @Override
    public void update(int timeScore, int jumpScore) {
        this.timeScore = timeScore;
        this.jumpScore=jumpScore;

    }


}
