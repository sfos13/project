package com.aor.DK.viewer.ranking;

import com.aor.DK.GUI.GUI;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.model.ranking.RankingElement;
import com.aor.DK.viewer.Viewer;

import java.util.List;

public class RankingViewer extends Viewer<Ranking> {

    Ranking ranking;

    List<RankingElement>  list;


    public RankingViewer(Ranking model) {
        super(model);
        this.ranking = model;
        list = ranking.getList();
    }




    @Override
    public void drawElements(GUI gui) {
        for(RankingElement element : list) {
        }
    }
}
