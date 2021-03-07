package drawGraphics;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    private static final int PREF_SIZE = 200;
    
    private Shape shape = null;

    @Override
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        if (shape != null) {
            shape.draw(g);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(shape.getNoOfShapes()), 2, 10);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_SIZE, PREF_SIZE); 
    }
    
    public void drawShape(Shape shape) {
        try {
            if (shape.x < 0 || shape.y < 0 || shape.x + shape.width > PREF_SIZE || shape.y + shape.height > PREF_SIZE) {
                Shape.count--;
                throw new OutsideBounds("Outside Bounds error");
            } else { 
                this.shape = shape; 
                repaint();
            }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Outside Bounds error.");
        }
            
    }
}
