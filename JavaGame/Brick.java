package JavaGame;


//This "Brick" class extends the "Structure" class. It is for the bricks used in the game.

//Imports
import java.awt.*;
import java.util.Random;

//Class definition
public class Brick extends Structure implements Constants {
    //Variables
    private int lives, hits;
    private boolean destroyed;
    public Item item;
    private Color itemColor;
    private Color[] blueColors = {BLUE_BRICK_ONE, BLUE_BRICK_TWO, BLUE_BRICK_THREE, Color.BLACK};
    private Color[] redColors = {RED_BRICK_ONE, RED_BRICK_TWO, RED_BRICK_THREE, Color.BLACK};
    private Color[] purpleColors = {PURPLE_BRICK_ONE, PURPLE_BRICK_TWO, PURPLE_BRICK_THREE, Color.BLACK};
    private Color[] yellowColors = {YELLOW_BRICK_ONE, YELLOW_BRICK_TWO, YELLOW_BRICK_THREE, Color.BLACK};
    private Color[] pinkColors = {PINK_BRICK_ONE, PINK_BRICK_TWO, PINK_BRICK_THREE, Color.BLACK};
    private Color[] grayColors = {GRAY_BRICK_ONE, GRAY_BRICK_TWO, GRAY_BRICK_THREE, Color.BLACK};
    private Color[] greenColors = {GREEN_BRICK_ONE, GREEN_BRICK_TWO, GREEN_BRICK_THREE, Color.BLACK};
    private Color[][] colors = {blueColors, redColors, purpleColors, yellowColors, pinkColors, grayColors, greenColors};

    //Constructor
    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        setDestroyed(false);

    }

    //Draws a brick
    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    public void brickIsDestroyed(){
        setDestroyed(true);
    }

    //Detect if the brick has been hit on its bottom, top, left, or right sides
    public boolean hitBottom(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y + height) && destroyed == false) {
            brickIsDestroyed();
            return true;
        }
        return false;
    }

    public boolean hitTop(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y) && destroyed == false) {
            brickIsDestroyed();
            return true;
        }
        return false;
    }

    public boolean hitLeft(int ballX, int ballY) {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x) && destroyed == false) {
            brickIsDestroyed();
            return true;
        }
        return false;
    }

    public boolean hitRight(int ballX, int ballY) {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x + width) && destroyed == false) {
            brickIsDestroyed();
            return true;
        }
        return false;
    }


    //Mutator methods

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    //Accessor methods

    public boolean isDestroyed() {

        return destroyed;
    }
}