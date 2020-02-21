/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author tangminhtin CE130438
 */
public class Paper extends JPanel {

    protected static Random random;     // Declare random
    protected ArrayList<Object> shapes; // Store shapes 

    /**
     * Constructor for class Paper
     */
    public Paper() {
        this.random = new Random();     // Initialize for random
        this.shapes = new ArrayList<>();    // Initialize for shapes
    }

    /**
     * Return random color with RGBA
     *
     * @return
     */
    public static Color randomRGBA() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    /**
     * Add new shape with type, max x, max y
     *
     * @param type
     * @param maxX
     * @param maxY
     */
    public void addShape(String type, int maxX, int maxY) {
        int x = random.nextInt(maxX * 3 / 4);     // Create random for x axis
        int y = random.nextInt(maxY * 3 / 4);     // Create random for y axis
        int width = random.nextInt(maxX / 2);   // Create random for width
        int height = random.nextInt(maxY / 2); // Create random for height
        Color line = randomRGBA();  // Create random color for line
        Color fill = randomRGBA();  // Create random color for fill
        int lineThickness = random.nextInt(20) + 1; // Create random line thickness
        // Add new shape into array list
        shapes.add(new Shapes(x, y, width, height, line, fill, lineThickness, type));
        repaint();  // Call method to repaint
    }

    /**
     * Method will clear any shape on panel
     */
    public void clear() {
        shapes.clear(); // Detele element in array
        repaint();  // Call method to repaint
    }

    /**
     * Method will draw shape
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            ((Shapes) s).draw(g); // Draw each shape in array list
        }
    }

}
