package com.aor.DK.model.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Menu{

    private List<String> entries;
    protected String message;
    private int currentEntry = 0;


    public Menu(List<String> entries, String message) {
        this.entries=entries;
        this.message=message;

    }

    public String getMessage() {
        return message;
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

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
