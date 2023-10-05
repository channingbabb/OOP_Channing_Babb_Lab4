package Channing_Babb_Lab4.shapes;

import java.awt.*;

/**
 * Circle class
 */
public class Circle extends ShapeIcon {
    // constructor
    public Circle(int width, int height) {
        super(width, height);
    }

    // paint the circle
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // paint the circle
        g.setColor(Color.GREEN);
        g.fillOval(x, y, getIconWidth(), getIconHeight());
    }
}
