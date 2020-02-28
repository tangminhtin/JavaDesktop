package prj311_graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author TangMinhTin CE130438
 */
class Shape {

    protected int x, y, width, height;// Store x, y axis and width, height
    protected Color line, fill;// Store color of line and fill
    protected int lineThickness; // Store line thickness
    protected String type;// Store type of shape

    /**
     * Constructor for Shapes
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param line
     * @param fill
     * @param lineThickness
     * @param type
     */
    public Shape(String type, int x, int y, int width, int height,
            int lineThickness, Color line, Color fill) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lineThickness = lineThickness;
        this.line = line;
        this.fill = fill;
    }

    /**
     * Method will draw rectangle or oval shape
     *
     * @param g
     */
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;// Cast graphics to graphics2d

        //draws fill shape
        g2D.setColor(fill);
        if (type.equals("rect")) {
            g2D.fillRect(x, y, width, height);// Draw fill of rectangle
        } else if (type.equals("oval")) {
            g2D.fillOval(x, y, width, height); // Draw fill of oval
        }

        //draws outline
        g2D.setStroke(new BasicStroke(lineThickness));
        g2D.setColor(line);
        if (type.equals("rect")) {
            g2D.drawRect(x, y, width, height);// Draw outline of rectangle
        } else if (type.equals("oval")) {
            g2D.drawOval(x, y, width, height);// Draw outline of oval
        }
    }
}
