package com.aor.DK.model.ranking;

import java.util.HashSet;
import java.util.Set;

public class ScoresDatabase implements Subject{
    private  Set<Observer> observer = new HashSet<>();
    private int timeScore=5000;
    private int jumpScore;
    private long lastMovement;

    public void ScoresDatabase(){
        this.lastMovement = System.currentTimeMillis();
    }

    public void setTimeScore(){
        long time = System.currentTimeMillis();
        if (time -lastMovement>2000){
            this.timeScore=-100;
        }
        System.out.println(timeScore);

        notifyObserver();

    }

    public void setJumpScore(){
        this.jumpScore=jumpScore+100;
        System.out.println(jumpScore);

        notifyObserver();
    }

    public int getJumpScore() {
        return jumpScore;
    }

    public int getTimeScore() {
        return timeScore;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer.add(observer);
        observer.update(this.timeScore,this.jumpScore);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observer.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observer.forEach(observer -> observer.update(this.timeScore,this.jumpScore));

    }
}
