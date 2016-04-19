package OurGAME;

import java.awt.*;

public class Structure implements Constants {
    // Variables
    private int x, y, width, height;
    private Color color;

    // Constructor
    public Structure( int x, int y, int width, int height, Color color ){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}