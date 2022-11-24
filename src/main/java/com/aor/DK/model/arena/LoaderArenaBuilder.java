package com.aor.DK.model.arena;

import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {

    private int width;
    private int height;

    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

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
//        int many_floor = 6;
        List<List<Floor>> floors = new ArrayList<>();
//        int offset = 5;
//        floors.add(new ArrayList<>());
        int floorLevel = -1;
        /*for (int i = 0; i < width; i++) {
            floors.get(0).add(new Floor(i, height - 3));
        }

        for (int x = 1; x <= many_floor; x++) {
            floors.add(new ArrayList<>());
            if (x % 2 == 0) {
                for (int i = 0; i < width - offset; i++) {
                    floors.get(x).add(new Floor(i, height - (x * 3 + 3)));
                }
            } else {
                for (int i = offset; i < width; i++) {
                    floors.get(x).add(new Floor(i, height - (x * 3 + 3)));
                }
            }
        }

        floors.add(new ArrayList<>());
        for (int i = (width/2) - 8 ; i < width/2 + 8; i++) {
            floors.get(7).add(new Floor(i, height - (7 * 3 + 3)));
        }
*/
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

    public int getLevel() {
        return level;
    }
}