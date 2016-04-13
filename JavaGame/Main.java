package JavaGame;

import javax.swing.*;

public class Main implements Constants {
    private static JFrame frame;
    //private static Board board;
    // GamePanel - maybe is like the board, but not sure
    private static GamePanel gamePanel;  
    //private static Container container;

    public static void main(String[] args){

        // Splash screen
        JWindow window = new JWindow();
        window.getContentPane().add(new JLabel(new ImageIcon("images/icon.png"), SwingConstants.CENTER));
        window.setBounds(0, 0, 72, 72);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);

        frame = new JFrame("Brick Breaker Game version 1.1.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.WIDTH,Constants.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon("images/icon.png").getImage());
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