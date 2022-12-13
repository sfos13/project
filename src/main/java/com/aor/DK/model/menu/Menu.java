package com.aor.DK.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu{
    protected List<String> entries;
    protected int currentEntry = 0;
    protected String message;
    protected String mod;

    public Menu(String mod) {
        this.mod=mod;
        parse(mod);
    }

    protected void parse(String mod) {
        if (mod.equals("Start")) {
            this.entries = Arrays.asList("Start", "Instructions", "Ranking","Exit");
            this.message = "Donkey Kong";
        }
        if (mod.equals("Instructions")) {
            this.entries = Arrays.asList("Start","Exit to Menu");
            this.message = "Instructions";
        }
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
        return currentEntry == Entry;
    }

    public boolean isSelected_String(String Entry) {
        return entries.get(currentEntry).equals(Entry);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getMessage() {
        return message;
    }

    public String getMod() {return mod;}
}
