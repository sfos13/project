package com.aor.DK.model.ranking;

public class Scoreboard implements Observer{

    private Subject resultData;

    public Scoreboard(Subject resultData){
        this.resultData=resultData;
        this.resultData.registerObserver(this);
    }

    @Override
    public void update(int timeScore, int jumpScore) {
        //print
    }
}
