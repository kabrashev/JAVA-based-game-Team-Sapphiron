package JavaGame;

import java.awt.*;

public class Structure implements Constants {
    // Variables
    protected int x, y, width, height;
    protected Color color;

    // Constructor
    public Structure( int x, int y, int width, int height, Color color ){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    //draw a structure
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
    }

    //setter - x
    public void setX(int x) {
        this.x = x;
    }
    //getter - x
    public int getX() {
        return x;
    }
    //setter - y
    public void setY(int y) {
        this.y = y;
    }
    //getter - y
    public int getY() {
        return y;
    }
    //setter - width
    public void setWidth(int width) {
        this.width = width;
    }
    //getter - width
    public int getWidth() {
        return width;
    }
    //setter - height
    public void setHeight(int height) {
        this.height = height;
    }
    //getter - height
    public int getHeight() {
        return height;
    }
    //setter - color
    public void setColor(Color color) {
        this.color = color;
    }
    //getter - color
    public Color getColor() {
        return color;
    }
}
