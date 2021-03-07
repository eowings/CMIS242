package drawGraphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Project3 {
    
    private static Color getColor(String color) {
        if(color.equals("Red"))
            return Color.RED;
        else if (color.equals("Blue"))
            return Color.BLUE;
        else if (color.equals("Yellow"))
            return Color.YELLOW;
        else if(color.equals("Green"))
            return Color.GREEN;
        else if(color.equals("Orange"))
            return Color.ORANGE;
        else if(color.equals("Magenta"))
            return Color.MAGENTA;
        return Color.BLACK;
    }
    
    public static void main(String[] args) {
 
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //text fields
        JPanel panel1 = new JPanel(new GridLayout(7, 2));
        panel1.setPreferredSize(new Dimension(200, 220));
        panel1.add(new JLabel("Shape Type"));
        String[] shapeType = { "Oval", "Rectanglar"};
        JComboBox<String> shapeDD = new JComboBox<>(shapeType);
        panel1.add(shapeDD);
        
        panel1.add(new JLabel("Fill Type"));
        String[] fillType = { "Solid", "Hollow"};
        JComboBox<String> fillDD = new JComboBox<>(fillType);
        panel1.add(fillDD);
        
        panel1.add(new JLabel("Color"));
        String[] colors = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};
        JComboBox<String> colorDD = new JComboBox<>(colors);
        panel1.add(colorDD);
        
        panel1.add(new JLabel("Width"));
        JTextField widthTF = new JTextField();
        panel1.add(widthTF);
        panel1.add(new JLabel("Height"));
        JTextField heightTF = new JTextField();
        panel1.add(heightTF);
        panel1.add(new JLabel("x coordinate"));
        JTextField xTF = new JTextField();
        panel1.add(xTF);
        panel1.add(new JLabel("y coordinate"));
        JTextField yTF = new JTextField();
        panel1.add(yTF);
        
        //drawing area
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(220, 240));
        panel2.setBorder(new TitledBorder("Shape drawing"));         
        Drawing d = new Drawing();
        panel2.add(d);
        panel2.setVisible(true);
        
        //upper area together
        JPanel panel3 = new JPanel();      
        panel3.add(panel1);
        panel3.add(panel2);
        
        //button 
        JButton b = new JButton("Draw");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                 try {
                     String shape = String.valueOf(shapeDD.getSelectedItem());
                     String fill = String.valueOf(fillDD.getSelectedItem());
                     boolean isSolid = false;
                     if (fill.equals("Solid"))
                         isSolid = true;  
                     else 
                         isSolid = false;
                     String colorStr = String.valueOf(colorDD.getSelectedItem());
                     Color color = getColor(colorStr);
                     int width = Integer.parseInt(widthTF.getText());
                     int height = Integer.parseInt(heightTF.getText());
                     int x = Integer.parseInt(xTF.getText());
                     int y = Integer.parseInt(yTF.getText());
                     if (shape.equals("Rectanglar")) {
                         Rectangle rect = new Rectangle(x, y, width, height);
                         Shape myrect = new Rectanglar(rect, color, isSolid );
                         d.drawShape(myrect);
                         //panel2.repaint();                    
                     } else if (shape.equals("Oval")) {
                         Rectangle rect = new Rectangle(x, y, width,height); 
                         Shape myOval = new Oval(rect, color, isSolid);
                         d.drawShape(myOval);
                         //panel2.repaint();
                     } else
                         throw new Exception();
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Error input.");
                 }
            }
        });       
        JPanel panel4 = new JPanel();
        panel4.add(b);
      
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(panel3);
        panel.add(panel4);
      
        int res= JOptionPane.showOptionDialog(frame, panel,"Geometric Drawing", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, new Object[]{}, null);
        //Exit on close
        if (res == -1)
            System.exit(0);
    }//end main
}
