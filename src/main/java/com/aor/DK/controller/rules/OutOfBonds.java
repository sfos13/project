package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;

public class OutOfBonds implements Validation {
    Position positionMario;
    int width;

    public OutOfBonds(Position position, Arena arena){
        this.width=arena.getWidth();
        this.positionMario=position;
    }
    @Override
    public boolean isValid() {
         return !(positionMario.getX() >= 0 && positionMario.getX() < width-1);
        }


}
