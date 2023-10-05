package Channing_Babb_Lab4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Channing_Babb_Lab4.shapes.Circle;
import Channing_Babb_Lab4.shapes.ShapeIcon;
import Channing_Babb_Lab4.shapes.Triangle;

/**
 * This is the main class for the ShapeIcon application.  This class contains an array of ShapeIcon objects and displays them in a JFrame.
 */
public class Main {
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 600;
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 600;

     // main
    public static void main(String[] args) {
        ShapeIcon[] shapes = { new Circle(100, 100), new Circle(300, 300), new Triangle(500, 500) };
        Measurable maxShape = maximum(shapes);
        System.out.println(maxShape.measure() + " is the largest shape.");
        displayShapes(shapes);
    }

    /**
     * Finds the maximum Measurable object in an array of Measurable objects (Shapes).
     * @param measurables 
     * @return
     */
    public static Measurable maximum(Measurable[] measurables) {
        Measurable max = measurables[0];
        for (int i = 1; i < measurables.length; i++) {
            if (measurables[i].measure() > max.measure()) {
                max = measurables[i];
            }
        }
        return max;
    }

    /**
     * Sorts an array of ShapeIcon objects based on their measurements from measure().
     * From largest to smallest.
     * @param shapes
     */
    public static void sort(ShapeIcon[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[i].measure() < shapes[j].measure()) {
                    ShapeIcon temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
        }
    }

    /**
     * Displays an array of ShapeIcon objects in a JFrame.
     * @param shapes
     */
    public static void displayShapes(ShapeIcon[] shapes) {
        sort(shapes);
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Shapes...");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                int x = 0;
                int y = 0;
                for (ShapeIcon shape : shapes) {
                    shape.paintIcon(this, g, x, y);
                    // if last shape in row, reset x and increment y
                    if (shape == shapes[0]) {
                        // create jlabel specifying that this is the largest shape
                        JLabel label = new JLabel("Largest Shape");

                        // x+((shape.getIconWidth()/2)-40) centers the label under the shape
                        label.setBounds(x+((shape.getIconWidth()/2)-40), shape.getIconHeight(), 100, 100);
                        this.add(label);

                    }
                    // increment x for the next shape
                    x += shape.getIconWidth();
                }
            }
        };
        // set the layout to null so that the shapes are displayed in the correct location
        panel.setLayout(null);
        panel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        for (ShapeIcon shape : shapes) {
            // add a label for each shape
            panel.add(new JLabel(shape));
        }
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
