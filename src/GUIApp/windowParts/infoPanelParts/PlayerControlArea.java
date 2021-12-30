package GUIApp.windowParts.infoPanelParts;

import javax.swing.*;
import java.awt.*;

public class PlayerControlArea extends JPanel {
    private JButton btnUp;
    private JButton btnDown;
    private JButton btnLeft;
    private JButton btnRight;

    public PlayerControlArea(){
        setLayout(new GridLayout(2,3));

        btnUp = new JButton("Up");
        btnDown = new JButton("Down");
        btnLeft = new JButton("Left");
        btnRight = new JButton("Right");

        add(btnUp);
        add(btnLeft);
        add(btnDown);
        add(btnRight);
    }
}
