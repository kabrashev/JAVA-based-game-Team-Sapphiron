package JavaGame;

import javax.swing.*;
import java.awt.*;

public class Main implements Constants {
    private static JFrame frame;
    private static Board board;
    private static Container container;

    public static void main(String[] args){

        frame = new JFrame("Brick Breaker Game version 1.1.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("JavaGame/Images/Icon.png"));

        board = new Board(WINDOW_WIDTH,WINDOW_HEIGHT);

        container = frame.getContentPane();
        container.add(board);

        frame.setVisible(true);
    }
}
