package com.aor.DK.controller.rules;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;

public class DonkeyCrash implements MarioValidation {

    Position positionDonkey;
    Position positionMario;


    public DonkeyCrash (Position positionMario, Arena arena) {
        this.positionDonkey= arena.getDonkeyKong().getPosition();
        this.positionMario = positionMario;
    }

    @Override
    public boolean isValid() {
            return positionDonkey.equals(positionMario);
    }
}
