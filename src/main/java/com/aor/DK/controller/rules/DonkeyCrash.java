package com.aor.DK.controller.rules;
import com.aor.DK.model.Position;

public class DonkeyCrash implements MarioValidation {

    Position positionDonkey;
    Position positionMario;

    public DonkeyCrash (Position positionMario, Position positionDonkey) {
        this.positionDonkey= positionDonkey;
        this.positionMario = positionMario;
    }

    @Override
    public boolean isValid() {
            return positionDonkey.equals(positionMario);
    }
}
