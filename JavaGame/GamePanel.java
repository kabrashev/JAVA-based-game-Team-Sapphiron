package JavaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GamePanel extends JPanel implements Constants {
    //Fields running is true, when the game is running, image is what we show, g is drawing on the image
    private boolean running;
    private BufferedImage image;
    private Graphics2D g;
    //add the ball and the paddle
    private Ball ball;
    private Paddle paddle;
    private Brick[][] brick = new Brick[16][5];
    private Color[] colors = {RED_BRICK, YELLOW_BRICK, GREEN_BRICK, ORANGE_BRICK, BLUE_BRICK};

    private myMouseMotionListener mouseListener;
    private BoardListener boardListener;

    public GamePanel() {

        createBricks();

        ball = new Ball();

        paddle = new Paddle();

        running = true;

        //adding the mouse Listener
        mouseListener = new myMouseMotionListener();
        boardListener = new BoardListener();
        addMouseMotionListener(mouseListener);
        addKeyListener(boardListener);

        image = new BufferedImage(Constants.WIDTH, Constants.HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }

    private void createBricks() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 5; j++) {
                Random randomNumber = new Random();
                Color color = colors[randomNumber.nextInt(5)];
                brick[i][j] = new Brick((i * BRICK_WIDTH), ((j * BRICK_HEIGHT) + (BRICK_HEIGHT / 2)), (BRICK_WIDTH - 3), (BRICK_HEIGHT - 3), color);
            }
        }
    }


    public void playGame() {
        //Game Loop

        while (running) {
            //Update
            update();
            //Draw
            draw();
            //displayImage
            repaint();

            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCollisions() {
        Rectangle ballRect = ball.getRect();
        Rectangle paddleRect = paddle.getRect();

        if (ballRect.intersects(paddleRect)) {
            ball.setDirectionY(-ball.getDirectionY());
        }
        checkBricks((int) ball.getX(), (int) ball.getY());
    }

    public void checkBricks(int x1, int y1) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 5; j++) {
                if (brick[i][j].hitBottom(x1, y1)) {
                    ball.setDirectionY(-ball.getDirectionY());
                }
                if (brick[i][j].hitTop(x1, y1)) {
                    ball.setDirectionY(-ball.getDirectionY());
                }
                if (brick[i][j].hitLeft(x1, y1)) {
                    ball.setDirectionX(-ball.getDirectionX());
                }
                if (brick[i][j].hitRight(x1, y1)) {
                    ball.setDirectionX(-ball.getDirectionX());
                }
            }
        }
    }

    public void update() {
        checkCollisions();
        ball.update();
    }

    public void draw() {
        //Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        ball.draw(g);
        paddle.draw(g);

        //bricks
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 5; j++) {
                brick[i][j].draw(g);
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, Constants.WIDTH, Constants.HEIGHT, null);

        g2.dispose();

    }

    private class myMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {

        }


        // The mouse changes the position of the paddle
        @Override
        public void mouseMoved(MouseEvent e) {
            paddle.movePaddle(e.getX());
        }
    }

    private class BoardListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent ke) {
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                if (running == true) {
                    running = false;
                }else {
                    running = true;
                }
            }
        }
    }
}