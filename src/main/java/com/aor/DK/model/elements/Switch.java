package com.aor.DK.model.elements;

import com.aor.DK.model.Position;

public class Switch extends Element{

    private boolean isOn;
    public Switch(int x, int y) {
        super(x, y);
        isOn = true;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        isOn = false;
    }

}
