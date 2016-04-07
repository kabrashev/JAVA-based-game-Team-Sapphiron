package JavaGame;

import javax.swing.*;
import java.awt.*;

public class Main implements Constants {
    private static JFrame frame;
    //private static Board board;
    // GamePanel - maybe is like the board, but not sure
    private static GamePanel gamePanel;  
    //private static Container container;

    public static void main(String[] args){

        frame = new JFrame("Brick Breaker Game version 1.1.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.WIDTH,Constants.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("JavaGame/Images/Icon.png"));
        frame.setVisible(true);
        //adds the gamePanel to the frame
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        
        gamePanel.playGame();
        // board = new Board(WINDOW_WIDTH,WINDOW_HEIGHT);

        // container = frame.getContentPane();
        // container.add(board);

       
    }
}
