package com.aor.DK.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu{
    private final String mod;
    private List<String> entries;
    private int currentEntry = 0;
    protected String message;


    public Menu(String mod) {
        this.mod=mod;
        if (mod=="Start")
            this.entries = Arrays.asList("Start", "Instructions", "Exit");
            this.message  = "Menu";

        if (mod=="Win")
            this.entries = Arrays.asList("Start", "Instructions", "Exit");
            this.message  = "Congratulations! You won the game!";
        if (mod=="Lost") this.entries = Arrays.asList("New Game?", "Instructions", "Exit");
            this.message  = "Try again! It's just a Donkey Kong";
        if (mod=="Instructions")
            this.entries=Arrays.asList("Start","Exit");
            this.message= "Instructions";
    }


     public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected_Number(int Entry) {
        if (currentEntry == Entry) {
            return true;
        }
        return false;
    }

    public boolean isSelected_String(String Entry) {
            if (entries.get(currentEntry) == Entry) {
                return true;
            }
        return false;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getCurrentEntry (){
        return this.currentEntry;
    }

    public String getMessage() {
        return message;
    }
}
