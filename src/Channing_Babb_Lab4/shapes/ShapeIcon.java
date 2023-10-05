package Channing_Babb_Lab4.shapes;
import javax.swing.*;

/**
 * ShapeIcon Abstract Class
 */
abstract public class ShapeIcon implements Icon, Measurable {
    // define width and height
    private int width;
    private int height;

    // constructor
    public ShapeIcon( int width, int height) {
        this.width = width;
        this.height = height;
    }

    // width getter
    public int getIconWidth() {
        return width;
    }

    // height getter
    public int getIconHeight() {
        return height;
    }

    // measure method
    public double measure() {
        int width = getIconWidth();
        int height = getIconHeight();
        double area = width * height;
        double perimeter = (width * 2) + (height * 2);

        // chose to add area and perimeter together
        return area + perimeter;
    }
}
