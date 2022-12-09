package com.aor.DK.viewer.Ranking;

import com.aor.DK.model.ranking.Scores;
import com.aor.DK.model.ranking.ScoresDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayerNameGUI extends JFrame {

    JFrame frame;
    JTextField textField;

    public PlayerNameGUI(){
        frame = new JFrame("Name Player");
        JButton button = new JButton("OK");
        button.setBounds(350,350,100,50);
        JLabel label = new JLabel("If you want to register your points, write your name");
        label.setBounds(100,0,500,200);
        textField = new JTextField("Start",100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.add(label);
        frame.add(textField);

        frame.pack();
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(this::actionButtonOk);

    }

    public void actionButtonOk(ActionEvent e){
        String name= textField.getText();
        if (name.equals("")) name="Player";
        ScoresDatabase scoresDatabase = new ScoresDatabase();
        Scores scores = new Scores(name, scoresDatabase);
        System.exit(0);

    }
}
