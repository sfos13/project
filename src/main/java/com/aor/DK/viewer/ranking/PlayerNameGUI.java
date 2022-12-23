package com.aor.DK.viewer.ranking;

import com.aor.DK.Game;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.model.ranking.Ranking;
import com.aor.DK.model.ranking.RankingElement;
import com.aor.DK.states.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class PlayerNameGUI extends JFrame {

    JFrame frame;
    JTextField textField;
    int score;

    Game game;


    public PlayerNameGUI(Game game, int score) {
        this.game = game;
        this.score = score;
        frame = new JFrame("Name Player");
        JButton button = new JButton("OK");
        button.setBounds(200, 180, 60, 50);
        button.setBackground(Color.white);
        JLabel label = new JLabel("If you want to register your points, write your name");
        label.setBounds(20, 0, 500, 200);
        label.setFont(new Font("Jumpman", Font.BOLD, 18));
        label.setForeground(Color.white);
        textField = new JTextField(40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);
        frame.add(label);
        frame.add(textField);
        frame.pack();
        frame.setSize(500, 300);
        textField.setLocation(30, 150);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);
        button.addActionListener(e -> {
            try {
                actionButtonOk(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    public void actionButtonOk(ActionEvent e) throws IOException {
        String name = textField.getText();
        if (name.equals("")) name = "Player";
        frame.setVisible(false);
        Ranking ranking = new Ranking();
        ranking.addPerson(new RankingElement(name, score));
        ranking.save();
        frame.dispose();
        game.setState(new MenuState(new Menu("Start")));
    }
}

