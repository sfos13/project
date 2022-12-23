package com.aor.DK.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    protected List<String> entries;
    protected int currentEntry = 0;
    protected String message;
    protected String mod;

    public Menu(String mod) {
        this.mod = mod;
        parse(mod);
    }

    protected void parse(String mod) {
        if (mod.equals("Start")) {
            this.entries = Arrays.asList("Start", "Instructions", "Ranking", "Exit");
            this.message = "Donkey Kong";
        }
        if (mod.equals("Instructions")) {
            this.entries = List.of("Exit to Menu SPACE");
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

    public boolean isSelectedNumber(int entry) {
        return currentEntry == entry;
    }

    public boolean isSelectedString(String entry) {
        return entries.get(currentEntry).equals(entry);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getMessage() {
        return message;
    }

    public String getMod() {
        return mod;
    }
}
