package Channing_Babb_Lab4.shapes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;


/**
 * Rectangle class
 */
public class Rectangle extends ShapeIcon {
    // constructor
    public Rectangle(int width, int height) {
        super(width, height);
    }

    // paint the rectangle
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // paint the rectangle
        g.setColor(Color.RED);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
    }
}
