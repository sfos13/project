package com.aor.DK.model.ranking;

public class Ranking implements Observer{

    private Subject resultData;

    public Ranking (Subject resultData){
        this.resultData=resultData;
        this.resultData.registerObserver(this);
    }

    @Override
    public void update(int timeScore, int jumpScore) {
        //print
    }
}
