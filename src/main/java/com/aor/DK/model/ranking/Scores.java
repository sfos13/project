package com.aor.DK.model.ranking;


import com.aor.DK.model.elements.Element;

public class Scores extends Element {
    int jumpScore;
    int timeScore=5100;
    public Scores(int x, int y) {

        super(x, y);
    }
    public void setJumpScore(){
        jumpScore+=100;
    }


    public void setTimeScore(){
        this.timeScore-=100;

    }
    public int getJumpScore(){
        return this.jumpScore;
    }

    public int getTimeScore(){
        return this.timeScore;
    }

    public int getTotal() {return jumpScore+timeScore;}


}
