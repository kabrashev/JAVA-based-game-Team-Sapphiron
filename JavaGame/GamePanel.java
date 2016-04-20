package JavaGame;


        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseMotionListener;
        import java.awt.image.BufferedImage;
        import java.util.Random;

public class GamePanel extends JPanel implements Runnable,Constants {
    //Fields running is true, when the game is running, image is what we show, g is drawing on the image
    private boolean isRunning;
    private BufferedImage image;
    private Graphics2D g;
    //add the ball and the paddle
    private Ball ball;
    private Paddle paddle;
    private Brick[][] brick = new Brick[16][5];
    private Color[] colors = {RED_BRICK, YELLOW_BRICK, GREEN_BRICK, ORANGE_BRICK, BLUE_BRICK};
    private int numberOfLives = PLAYER_LIVES;
    private int score = 0;
    private int level = 1;
    private int bricksLeft = 16*5;

    private myMouseMotionListener mouseListener;

    private Thread game;

    public GamePanel() {
        super.setSize(800, 600);
        setFocusable(true);

        createBricks();

        ball = new Ball();

        paddle = new Paddle();

        isRunning = true;
        //adding the mouse Listener
        mouseListener = new myMouseMotionListener();
        addMouseMotionListener(mouseListener);

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



    public void checkCollisions() {
        Rectangle ballRect = ball.getRect();
        Rectangle paddleRect = paddle.getRect();

        if (ballRect.intersects(paddleRect)) {
            ball.setDirectionY(-ball.getDirectionY());
        }
        checkBricks(ball.getX(), ball.getY());
    }

    public void checkBricks(int x1, int y1) {
        if(bricksLeft == 0){
            level++;
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 5; j++) {
                if (brick[i][j].hitBottom(x1, y1)) {
                    ball.setDirectionY(-ball.getDirectionY());
                    score += 50;
                    bricksLeft--;
                }
                if (brick[i][j].hitTop(x1, y1)) {
                    ball.setDirectionY(-ball.getDirectionY());
                    score += 50;
                    bricksLeft--;
                }
                if (brick[i][j].hitLeft(x1, y1)) {
                    ball.setDirectionX(-ball.getDirectionX());
                    score += 50;
                    bricksLeft--;
                }
                if (brick[i][j].hitRight(x1, y1)) {
                    ball.setDirectionX(-ball.getDirectionX());
                    score += 50;
                    bricksLeft--;
                }
            }
        }
    }

    public void checkIfOut(int y1) {
        if (y1 > Constants.HEIGHT - 90) {
            numberOfLives--;
            score -= 100;
            if (numberOfLives == 0) {

                createBricks();
                numberOfLives = PLAYER_LIVES;
                score = 0;
                isRunning = false;
            }
            ball.reset();
            repaint();

        }
    }


    public void update() {
        checkCollisions();
        ball.update();
    }

    public void draw() {
        // Background
        //g.drawImage(ImageLoader.loadImage("Images/bckg.jpg"), 0, 0, 800, 600, null);
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

        g2.setColor(Color.BLACK);
        g2.drawImage(image, 0, 0, Constants.WIDTH, Constants.HEIGHT, null);
        g2.drawString("Lives: " + numberOfLives, 10, getHeight() - (getHeight() / 10));
        g2.drawString("Score: " + score, 10, getHeight() - (2 * (getHeight() / 10)) + 25);
        g2.drawString("Level: " + level, 10, getHeight() - (3 * (getHeight() / 10)) + 50);
        g2.dispose();


    }

    @Override
    public void run() {
        while (isRunning) {
            //Update
            update();
            //Draw
            draw();
            //displayImage

            checkIfOut(ball.getY());
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie) {

            }
        }
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

}