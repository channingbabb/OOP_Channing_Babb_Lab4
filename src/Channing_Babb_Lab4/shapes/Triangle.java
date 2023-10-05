package Channing_Babb_Lab4.shapes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

/**
 * Triangle class
 */
public class Triangle extends ShapeIcon {
    // constructor
    public Triangle(int width, int height) {
        super(width, height);
    }

    // paint the triangle
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // paint the triangle
        g.setColor(Color.BLUE);

        // explanation for the following code (this is both for my sake and yours):
        // the first two arrays are the x and y coordinates of the three points of the triangle.  I am adding x to getIconWidth() and y to getIconHeight() to each point so that the triangle is drawn in the correct location.
        // the third array is the number of points in the polygon
        // the first two points are the top left and top right corners of the triangle
        // the third point is the bottom middle of the triangle
        //npoints = number of points in the polygon
        g.fillPolygon(new int[]{x, x + getIconWidth(), x + (getIconWidth() / 2)}, new int[]{y, y, y + getIconHeight()}, 3);

    }
}
