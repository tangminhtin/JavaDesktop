/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj311_graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author TangMinhTin CE130438
 */
public class ShapeDragDrop extends Shape {

    /**
     * Create constructor for ShapeDragDrop class
     *
     * @param type
     * @param x
     * @param y
     * @param width
     * @param height
     * @param lineThickness
     * @param line
     * @param fill
     */
    public ShapeDragDrop(String type, int x, int y, int width, int height, int lineThickness, Color line, Color fill) {
        super(type, x, y, width, height, lineThickness, line, fill);
    }

    /**
     * Override method draw to draw rectangle, oval and line
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g; // Cast graphics to graphics2d

        // Draw filled shape
        g2D.setColor(fill);
        if (type.equals("rect")) {
            g2D.fillRect(x, y, width, height);// Draw fill of rectangle
        } else if (type.equals("oval")) {
            g2D.fillOval(x, y, width, height);// Draw fill of oval
        }

        // Draw stroke
        g2D.setStroke(new BasicStroke(lineThickness));
        g2D.setColor(line);
        if (type.equals("rect")) {
            g2D.drawRect(x, y, width, height);// Draw outline of rectangle
        } else if (type.equals("oval")) {
            g2D.drawOval(x, y, width, height);// Draw outline of oval
        } else if (type.equals("line")) {
            g2D.drawLine(x, y, x + width - 1, y + height - 1);// Draw line of line
        }
    }

}
