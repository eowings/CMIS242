package weekSix;
//////////////////////////////////////////////////////////
//File Name: Shape.java
//Author: Eddy Owings
//Date: 11/28/2020
//Description: An abstract class that extends the 
// predefined Java class Rectangle. Contains two sub classes
// Oval and Rectangular.
//////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape extends Rectangle {    
    private boolean isShapeSolid;
    static Color shapeColor;
    static int howManyShapes = 0;
    
    public Shape (Color shaCo, boolean shaSol, Rectangle rec) {
        super(rec);
        shapeColor = shaCo;
        isShapeSolid = shaSol;
        howManyShapes ++;        
    }
    
    public static Color setColor (Graphics g, String color) {
        if(color.equals("Red"))
            return shapeColor = Color.RED;
        else if (color.equals("Blue"))
            return shapeColor = Color.BLUE;
        else if (color.equals("Yellow"))
            return shapeColor = Color.YELLOW;
        else if(color.equals("Green"))
            return shapeColor = Color.GREEN;
        else if(color.equals("Orange"))
            return shapeColor = Color.ORANGE;
        else if(color.equals("Magenta"))
            return shapeColor = Color.MAGENTA;
        return shapeColor = Color.BLACK;
        
    }
    
    public boolean getSolid () {
        return isShapeSolid;
    }
    
    public int getNoOfShapes() {
        return howManyShapes;
    }
    
    public abstract void draw (Graphics g);
    
}// End Shape

class Oval extends Shape {
    
    Oval(Color shaCo, boolean shaSol, Rectangle rec) {
        super(shaCo, shaSol, rec);
    }
    
    @Override
    public void draw (Graphics g) {
        g.setColor(shapeColor); 
        int x = super.x;
        int y = super.y;
        int width = super.width;
        int height = super.height;
        if (getSolid())
            g.fillOval(x, y, width, height);
        else
            g.drawOval(x, y, width, height); 
    }

}// End Oval

class Rectanglar extends Shape {    
    
    public Rectanglar(Color shaCo, boolean shaSol, Rectangle rec) {
        super(shaCo, shaSol, rec);
    }
    
    @Override
    public void draw (Graphics g) {
        g.setColor(shapeColor);
        int x = super.x;
        int y = super.y;
        int width = super.width;
        int height = super.height;
        if (getSolid())
            g.fillRect(x, y, width, height);
        else 
            g.drawRect(x, y, width, height);
    }

}// End Rectangular