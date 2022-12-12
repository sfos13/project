package com.aor.DK.controller.rules;

import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.DonkeyKong;
import com.aor.DK.model.elements.Fire;

import java.util.List;

public class Crash implements Validation {
    Position positionMario;

    List<Barrel> barrels;
    
    List<Fire> fireMonsters;
    
    DonkeyKong donkeyKong;

    public Crash(Position positionMario, Arena arena) {
        this.positionMario=positionMario;
        this.barrels = arena.getBarrels();
        this.fireMonsters = arena.getFireMonsters();
        this.donkeyKong = arena.getDonkeyKong();
    }

    @Override
    public boolean isValid() {
        if(donkeyKong.getPosition().equals(positionMario) 
                || donkeyKong.getPosition().getUp().equals(positionMario) 
                || donkeyKong.getPosition().getLeft().equals(positionMario) 
                || donkeyKong.getPosition().getLeft().getUp().equals(positionMario)) return true;
        for(Barrel barrel : barrels) {
            if(barrel.getPosition().equals(positionMario)) {
                return true;
            }
        }
        for(Fire fire : fireMonsters) {
            if(fire.getPosition().equals(positionMario)) {
                return true;
            }
        }
        return false;
        }
    }

