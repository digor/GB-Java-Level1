package GUIApp.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoArea extends JPanel {

    private JLabel title;
    private JLabel hp;
    private JLabel strength;
    private JLabel mana;
    private JLabel experience;

    public PlayerInfoArea(){
        setLayout(new GridLayout(5,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        title = new JLabel("Player Info", SwingConstants.CENTER);
        hp = new JLabel("Map: ");
        mana = new JLabel("Mana: ");
        strength = new JLabel("Strength: ");
        experience = new JLabel("Experience: ");

        add(title);
        add(hp);
        add(mana);
        add(strength);
        add(experience);
    }
}
