package com.aor.DK.Viewer.Ranking;

import javax.swing.*;

public class PlayerRegister extends JFrame {
    private JEditorPane ifYouWantToEditorPane;
    private JPanel mainPanel;
    private JTextField textFieldName;
    private JButton buttonOk;

    public PlayerRegister(){
        String name= String.valueOf(textFieldName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane((mainPanel));
        this.pack();

    }

}
