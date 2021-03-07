package weekSix;
//////////////////////////////////////////////////////////
//File Name: Project3.java
//Author: Eddy Owings
//Date: 11/28/2020
//Description: A class that contains main method and
// creates a GUI
//////////////////////////////////////////////////////////
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class Project3 extends JFrame {
    
    private JPanel contentPane;
    private JTextField heightFld;
    private JTextField xCoord;
    private JTextField yCoord;
    private JTextField widthFld;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Project3 frame = new Project3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }// End Main

    /**
     * Create the frame.
     */
    public Project3() {
        setTitle("Geometric Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 340);
        contentPane = new JPanel();
        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        String[] shapeTypes = {"Rectangle", "Oval"};
        JComboBox shapeType = new JComboBox(shapeTypes);
        //JComboBox<String> shapeType = new JComboBox<String>(shapeTypes);
        shapeType.setBounds(135, 25, 125, 22);
        contentPane.add(shapeType);
        
        JLabel lblNewLabel = new JLabel("Shape Type");
        lblNewLabel.setBounds(30, 29, 95, 14);
        contentPane.add(lblNewLabel);
        
        String[] fillTypes = {"Hollow", "Solid"};
        JComboBox fillType = new JComboBox(fillTypes);
        fillType.setBounds(135, 54, 125, 22);
        contentPane.add(fillType);
        
        JLabel lblFillType = new JLabel("Fill Type");
        lblFillType.setBounds(30, 58, 95, 14);
        contentPane.add(lblFillType);
        
        String[] colors = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};
        JComboBox colorType = new JComboBox(colors);
        colorType.setBounds(135, 83, 125, 22);
        contentPane.add(colorType);
        
        JLabel lblColor = new JLabel("Color");
        lblColor.setBounds(30, 87, 95, 14);
        contentPane.add(lblColor);
        
        JLabel lblWidth = new JLabel("Width");
        lblWidth.setBounds(30, 115, 95, 14);
        contentPane.add(lblWidth);
        
        JLabel lblColor_1_1 = new JLabel("Height");
        lblColor_1_1.setBounds(30, 143, 95, 14);
        contentPane.add(lblColor_1_1);
        
        JLabel lblColor_1_2 = new JLabel("x Coordinate");
        lblColor_1_2.setBounds(30, 171, 95, 14);
        contentPane.add(lblColor_1_2);
        
        JLabel lblColor_1_3 = new JLabel("y Coordinate");
        lblColor_1_3.setBounds(30, 199, 95, 14);
        contentPane.add(lblColor_1_3);
        
        heightFld = new JTextField();
        heightFld.setBounds(135, 140, 125, 20);
        contentPane.add(heightFld);
        heightFld.setColumns(10);
        
        xCoord = new JTextField();
        xCoord.setColumns(10);
        xCoord.setBounds(135, 168, 125, 20);
        contentPane.add(xCoord);
        
        yCoord = new JTextField();
        yCoord.setColumns(10);
        yCoord.setBounds(135, 196, 125, 20);
        contentPane.add(yCoord);
        
        widthFld = new JTextField();
        widthFld.setColumns(10);
        widthFld.setBounds(135, 112, 125, 20);
        contentPane.add(widthFld);        
        
        JPanel shapeDrawing = new JPanel();
        shapeDrawing.setBorder(new TitledBorder(null, "Shape Drawing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        shapeDrawing.setBounds(270, 11, 235, 235);
        contentPane.add(shapeDrawing);
        Drawing drawArea = new Drawing();
        shapeDrawing.add(drawArea);
        
        JButton Draw = new JButton("Draw");
        Draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){                
                 try {
                     String shape = String.valueOf(shapeType.getSelectedItem());
                     String fill = String.valueOf(fillType.getSelectedItem());
                     boolean isShapeSolid = false;
                     if (fill=="Solid")
                         isShapeSolid = true;  
                     else 
                         isShapeSolid = false;
                     String colorStr = String.valueOf(colorType.getSelectedItem());
                     Color color = Shape.setColor(null, colorStr);
                     int width = Integer.parseInt(widthFld.getText());
                     int height = Integer.parseInt(heightFld.getText());
                     int x = Integer.parseInt(xCoord.getText());
                     int y = Integer.parseInt(yCoord.getText());
                     if (shape.equals("Rectangle")) {
                         Rectangle rectangle = new Rectangle(x, y, width, height);
                         Shape rec = new Rectanglar(color, isShapeSolid, rectangle);
                         drawArea.drawShape(rec);                    
                     } else if (shape.equals("Oval")) {
                         Rectangle rectangle = new Rectangle(x, y, width,height); 
                         Shape oval = new Oval(color, isShapeSolid, rectangle);
                         drawArea.drawShape(oval);
                     } else
                         throw new Exception();
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Please use a valid integer.");
                 }
            }
        });
        Draw.setBounds(218, 261, 89, 23);
        contentPane.add(Draw);


    }// End Constructor
}//End Class
