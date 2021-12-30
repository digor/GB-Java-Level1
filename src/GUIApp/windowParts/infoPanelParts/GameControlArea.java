package GUIApp.windowParts.infoPanelParts;

import GUIApp.MainWindow;
import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControlArea extends JPanel {

    private JButton startGame;
    private JButton exitGame;

    public GameControlArea() {
        setLayout(new GridLayout(3,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        startGame = new JButton("START GAME");
        exitGame = new JButton("EXIT GAME");

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(new JLabel("= Game Control =", SwingConstants.CENTER));
        add(startGame);
        add(exitGame);
    }
}
