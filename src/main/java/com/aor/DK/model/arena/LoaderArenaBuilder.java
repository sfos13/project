package com.aor.DK.model.arena;

import com.aor.DK.model.Position;
import com.aor.DK.model.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = null;
        if (resource != null) {
            br = new BufferedReader(new FileReader(resource.getFile()));
        }

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Stair> createStairs() {
        List<Stair> stairs = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') {
                    stairs.add(new Stair(x, y));
                }
        }

        return stairs;
    }

    @Override
    protected List<List<Floor>> createFloor() {
        List<List<Floor>> floors = new ArrayList<>();
        int floorLevel = -1;
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            if (line.contains("#")) {
                floors.add(new ArrayList<>());
                floorLevel++;
                for (int x = 0; x < line.length(); x++)
                    if (line.charAt(x) == '#' || line.charAt(x) == 'H') floors.get(floorLevel).add(new Floor(x, y));
            }
        }
        return floors;
    }


    @Override
    protected Mario createMario() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'X') return new Mario(x, y);
        }
        return null;


    }

    @Override
    protected DonkeyKong createDonkeyKong() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D') return new DonkeyKong(x, y);
        }
        return null;    }

    @Override
    protected Princess createPrincess() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Princess(x, y);
        }
        return null;
    }

    @Override
    protected Position getSpawnBarrelPosition() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') return new Position(x, y);
        }
        return null;
    }

    @Override
    protected Position getSpawnFirePosition1() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '1') return new Position(x, y);
        }
        return null;
    }
    @Override
    protected Position getSpawnFirePosition2() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '2') return new Position(x, y);
        }
        return null;
    }

    @Override
    protected List<Switch> createSwitches() {
        List<Switch> switches = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'Z') {
                    switches.add(new Switch(x, y));
                }
        }
        return switches;
    }
}