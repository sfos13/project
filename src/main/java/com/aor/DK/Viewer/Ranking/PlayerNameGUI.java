package com.aor.DK.Viewer.Ranking;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.menu.Level;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.model.ranking.RankingElement;
import com.aor.DK.states.LevelState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class PlayerNameGUI extends JFrame {

    JFrame frame;
    JTextField textField;

    Game game;
    GUI gui;

    public PlayerNameGUI(Game game){
        this.game= game;
        frame = new JFrame("Name Player");
        JButton button = new JButton("OK");
        button.setBounds(200 ,180,60,50);
        button.setBackground(Color.white);
        JLabel label = new JLabel("If you want to register your points, write your name");
        label.setBounds(20,0,500,200);
        label.setFont(new Font("Jumpman",Font.BOLD,18));
        label.setForeground(Color.white);
        textField = new JTextField(40);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.add(label);
        frame.add(textField);
        frame.pack();
        frame.setSize(500,300);

        textField.setLocation(30,150);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(this::actionButtonOk);

    }

    public void actionButtonOk(ActionEvent e){
        String name= textField.getText();
        if (name.equals("")) name="Player";
        frame.setVisible(false);
        RankingElement rankingElement = new RankingElement(name, 0,0);
        Ranking ranking =new Ranking();
        ranking.addPerson(rankingElement);
        game.setState(new LevelState(new Level(1)));
        frame.dispose();
    }
}
