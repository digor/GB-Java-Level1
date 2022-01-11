package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;
import GUIApp.windowParts.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerControlArea extends JPanel {
    private JButton btnUp;
    private JButton btnDown;
    private JButton btnLeft;
    private JButton btnRight;

    private InfoPanel infoPanel;

    public PlayerControlArea(InfoPanel infoPanel){
        this.infoPanel = infoPanel;
        setLayout(new GridLayout(3,3));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnUp = new JButton("⮝");
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveUp);
            }
        });
        btnDown = new JButton("⮟");
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                infoPanel.updatePlayer(Player.playerMoveDown);
            }
        });
        btnLeft = new JButton("⮜");
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveLeft);
            }
        });
        btnRight = new JButton("⮞");
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.updatePlayer(Player.playerMoveRight);
            }
        });

        add(new JPanel());
        add(btnUp);
        add(new JPanel());
        add(btnLeft);
        add(new JPanel());
        add(btnRight);
        add(new JPanel());
        add(btnDown);
        add(new JPanel());
    }
}
