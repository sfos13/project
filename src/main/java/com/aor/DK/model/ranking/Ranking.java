package com.aor.DK.model.ranking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Ranking implements Serializable {

    List<RankingElement> list;
    public Ranking() throws IOException {
        this.list = new ArrayList<>();
        String line;
        String splitBy = ",";
        BufferedReader br = Files.newBufferedReader(Paths.get("scoreboard.csv"), UTF_8);
        while ((line = br.readLine()) != null) {
            String[] player = line.split(splitBy);
            list.add(new RankingElement(player[0], Integer.parseInt(player[1])));
        }
    }

    public void addPerson(RankingElement item) {
        list.add(item);
        sort();
        while (list.size() > 10)
            list.remove(list.size() - 1);
    }

    public List<RankingElement> getList() {
        return list;
    }

    public void setList(ArrayList<RankingElement> list) {
        this.list = list;
    }

    public void sort() {
        Collections.sort(list);
    }

    public void save() throws IOException {
        Writer outputFile = Files.newBufferedWriter(Paths.get("scoreboard.csv"), UTF_8);
        for (RankingElement element : list) {
            String out = element.name + "," + element.score + '\n';
            outputFile.write(out);
            outputFile.flush();
        }
    }
}
