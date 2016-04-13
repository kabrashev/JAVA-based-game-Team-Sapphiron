package JavaGame;

import java.awt.*;

//class definition
public class Brick extends Structure implements Constants {
    //variables definition
    private int hits;
    private boolean destroyed;

    //constructor of the class
    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        setHits(0);
        setDestroyed(false);
    }

    //setter - hits
    public void setHits(int hits) {
        this.hits = hits;
    }

    //getter - hits
    public int getHits() {
        return hits;
    }

    //setter - destroyed (false or true)
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    //getter - destroyed(false or true)
    public boolean getDestroyed() {
        return destroyed;
    }

    //draws a brick, if it's not destroyed
    @Override
    public void draw(Graphics graphics){
        if(!destroyed) {
            graphics.setColor(color);
            graphics.fillRect(x, y, width, height);
        }
    }

    public void addHit() {
        hits++;
        setDestroyed(true);
    }

    //Check if the brick has been hit
    public boolean hitLeft(int ballX, int ballY) {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x) && (destroyed == false)) {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitRight(int ballX, int ballY) {
        if ((ballY >= y) && (ballY <= y + height) && (ballX == x + width) && (destroyed == false)) {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitBottom(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y + height) && (destroyed == false)) {
            addHit();
            return true;
        }
        return false;
    }

    public boolean hitTop(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width + 1) && (ballY == y) && (destroyed == false)) {
            addHit();
            return true;
        }
        return false;
    }
}