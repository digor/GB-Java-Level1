package GUIApp.windowParts.infoPanelParts;

import GUIApp.model.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoArea extends JPanel {

    private String prefixHp = "Health: ";
    private String prefixStr = "Str: ";
    private String prefixPositions = "Position: ";

    private JLabel playerHP;
    private JLabel playerStr;
    private JLabel playerPosition;

    public PlayerInfoArea() {
        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerHP = new JLabel(prefixHp + "-");
        playerStr = new JLabel(prefixStr + "-");
        playerPosition = new JLabel(prefixPositions + "-:-");

        JLabel label = new JLabel("Player Info", SwingConstants.CENTER);
        label.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);
        add(label);
        add(playerHP);
        add(playerStr);
        add(playerPosition);
    }

    public void refresh(Player player){
        playerHP.setText(prefixHp+player.getHp());
        playerStr.setText(prefixStr+player.getStr());
        playerPosition.setText(prefixPositions+player.getPosition());
    }
}
