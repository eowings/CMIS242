package drawGraphics;

import java.awt.*;

public abstract class Shape extends Rectangle {    
    Color color;
    boolean isSolid;
    static int count = 0; 
    
    public Shape(Rectangle rec, Color color, boolean isSolid) {
        super(rec);
        this.color = color;
        this.isSolid = isSolid;
        count++;
    }
    
    public void setColor(Graphics g) {
        color = g.getColor();
    }
    
    public boolean getSolid() {
        return isSolid;
    }
    
    public int getNoOfShapes() {
        return count;
    }
    
    public abstract void draw (Graphics g);

}

class Oval extends Shape {
    
    public Oval(Rectangle rec, Color color, boolean isSolid) {
        super(rec, color, isSolid);
    }
    
    public void draw (Graphics g) {
        g.setColor(color); 
        int x = super.x;
        int y = super.y;
        int width = super.width;
        int height = super.height;
        if (getSolid())
            g.fillOval(x, y, width, height);
        else
            g.drawOval(x, y, width, height); 
    }

}

class Rectanglar extends Shape {    
    
    public Rectanglar(Rectangle rec, Color color, boolean isSolid) {
        super(rec, color, isSolid);
    }
    
    public void draw (Graphics g) {
        g.setColor(color);
        int x = super.x;
        int y = super.y;
        int width = super.width;
        int height = super.height;
        if (getSolid())
            g.fillRect(x, y, width, height);
        else 
            g.drawRect(x, y, width, height);
    }

}