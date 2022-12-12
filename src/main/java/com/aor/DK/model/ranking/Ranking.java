package com.aor.DK.model.ranking;


import java.io.Serializable;
import java.util.ArrayList;


public class Ranking implements Serializable {

        ArrayList<RankingElement> list;

        public Ranking() {
            this.list = new ArrayList<>();
        }

        public void addPerson(RankingElement item) {
            if (list.size() == 10)
                list.remove(9);
            list.add(item);
            sort();
        }

        public void setList(ArrayList<RankingElement> list) {
            this.list = list;
        }

        public ArrayList<RankingElement> getPeople() {
            return list;
        }

        public void sort() {
            list.sort(new RankingElement("A", 0,0));
        }

}
