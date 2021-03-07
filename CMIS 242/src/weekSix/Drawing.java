package weekSix;
//////////////////////////////////////////////////////////
//File Name: Drawing.java
//Author: Eddy Owings
//Date: 11/28/2020
//Description: Extends the predefined Java class JPanel. 
// It has one instance variable that contains the shape 
// that is currently drawn.
//////////////////////////////////////////////////////////
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Drawing extends JPanel {
    public Drawing() {
    }   
    Shape shape;    
    @Override
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        if (shape != null) {
            shape.draw(g);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(shape.getNoOfShapes()),2, 10);
        }
    }    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200); 
    }
    
    public void drawShape(Shape shape) {
        try {
            if (shape.x < 0 || shape.y < 0 || shape.x + shape.width > 200 || shape.y + shape.height > 200) {
                Shape.howManyShapes--;
                throw new OutsideBounds("Outside Bounds error");
            } else { 
                this.shape = shape; 
                repaint();
            }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Outside Bounds error.");
        }
            
    }// End drawShape
    
}// End Class
