package JavaGame;

import javax.swing.*;

public class Main implements Constants {
    private static JFrame frame;
    //private static Board board;
    // GamePanel - maybe is like the board, but not sure
    private static GamePanel gamePanel;
    //private static Container container;

    public static void main(String[] args) {

        // Show a image in the center of the screen for certain amount of time
        showSplash(1000);

        // Display a JFrame instance
        createFrame("Brick Breaker Game version 1.1.1");

        //adds the gamePanel to the frame
        gamePanel = new GamePanel();
        frame.add(gamePanel);
        gamePanel.playGame();

        // board = new Board(WINDOW_WIDTH,WINDOW_HEIGHT);
        // container = frame.getContentPane();
        // container.add(board);

    }

    private static void showSplash(int duration) {
        // Build the splash screen
        JWindow window = new JWindow();
        window.getContentPane().add(new JLabel(new ImageIcon("images/icon.png"), SwingConstants.CENTER));
        window.pack();
        window.setLocationRelativeTo(null);

        // Display it
        window.setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close it
        window.setVisible(false);
    }

    private static void createFrame(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon("images/icon.png").getImage());
        frame.setVisible(true);
    }

}