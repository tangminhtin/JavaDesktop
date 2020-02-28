/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj311_graphics;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author TangMinhTin CE130438
 */
public class PaperDragDrop extends Paper {

    /**
     * Method to remove the last shape before mouse released
     */
    public void removeLast() {
        if (shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);   // remove last shape
        }
    }

    /**
     * Method will add new shape to array list
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
    public void addShape(String type, int x, int y, int width, int height,
            int lineThickness, Color line, Color fill) {
        // Add new shape
        shapes.add(new ShapeDragDrop(type, x, y, width, height, lineThickness, line, fill));
        repaint();  // Call method to repaint
    }

    /**
     * Override method paint to paint shape
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            ((ShapeDragDrop) s).draw(g); // Draw each shape in array list
        }
    }

}
