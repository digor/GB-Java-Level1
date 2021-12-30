package GUIApp.windowParts;

import GUIApp.MainWindow;
import GUIApp.windowParts.infoPanelParts.GameControlArea;
import GUIApp.windowParts.infoPanelParts.GameInfoArea;
import GUIApp.windowParts.infoPanelParts.PlayerControlArea;
import GUIApp.windowParts.infoPanelParts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class InfoPanel extends JPanel {

    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerInfoArea playerInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea log;
    private JScrollPane scroll;

    public InfoPanel(){
        preparePanel();
        createParts();
        prepareLogs();

        add(gameControlArea);
        add(gameInfoArea);
        add(playerInfoArea);
        add(playerControlArea);
        add(scroll);
    }

    private void preparePanel(){
        setBackground(Color.YELLOW);
        setLayout(new GridLayout(5,1));
    }

    private void createParts(){
        gameControlArea = new GameControlArea();
        gameInfoArea = new GameInfoArea();
        playerInfoArea = new PlayerInfoArea();
        playerControlArea = new PlayerControlArea();
    }

    private void prepareLogs(){
        log = new JTextArea();
        scroll = new JScrollPane(log);
    }
}
