package GUIApp.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;

public class GameInfoArea extends JPanel {

    private JLabel title;
    private JLabel map;
    private JLabel level;
    private JLabel countTrap;

    public GameInfoArea(){
        setLayout(new GridLayout(4,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        title = new JLabel("Game Info", SwingConstants.CENTER);
        map = new JLabel("Map: ");
        level = new JLabel("Level: ");
        countTrap = new JLabel("Count trap: ");

        add(title);
        add(map);
        add(level);
        add(countTrap);
    }


}
