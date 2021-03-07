package weekFour;
//////////////////////////////////////////////////////////
//File Name: Project2.java
//Author: Eddy Owings
//Date: 11/14/2020
//Description: A class that will build a graphic user
// interface that will create an array of Automobile and
// its sub-classes.
//////////////////////////////////////////////////////////
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.*;
import java.util.List;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Project2 extends JFrame {
    // Fields and buttons that will be used outside of the constructor are initialized here.
    private 
    static JTextField makeAndModelField;
    static JTextField salesPriceField;
    static JTextField milesPerGallon;
    static JTextField weightInPounds;
    JTextField answerField;
    JButton clearButton;
    JButton computeButton;
    JButton reportButton;
    JRadioButton hybridRadioButton;
    JRadioButton electricRadioButton;
    JRadioButton otherRadioButton;
    List<Automobile> AutoArray;    
   
    // Constructor for the GUI.
    public Project2 () {     
        setMinimumSize(new Dimension(450, 350));
        getContentPane().setLayout(null);
        AutoArray = new ArrayList <>();
        JLabel oneFieldLabel = new JLabel("Make and Model");
        oneFieldLabel.setBounds(53, 11, 100, 14);
        getContentPane().add(oneFieldLabel);
        
        makeAndModelField = new JTextField();
        makeAndModelField.setBounds(171, 8, 185, 20);
        getContentPane().add(makeAndModelField);
        makeAndModelField.setColumns(10);
    
        JLabel twoFieldLabel = new JLabel("Sales Price");
        twoFieldLabel.setBounds(53, 46, 111, 14);
        getContentPane().add(twoFieldLabel);
    
        salesPriceField = new JTextField();
        salesPriceField.setBounds(171, 39, 185, 20);
        getContentPane().add(salesPriceField);
        salesPriceField.setColumns(10);        
        
        // Set buttons
        CheckButton listenForButton = new CheckButton();
        clearButton = new JButton("Clear Fields");
        clearButton.setBounds(53, 240, 144, 30);
        clearButton.addActionListener((ActionEvent actionEvent) -> {
            makeAndModelField.setText(null);
            salesPriceField.setText(null);
            milesPerGallon.setText(null);
            weightInPounds.setText(null);
            answerField.setText(null);
        });
        getContentPane().add(clearButton);  

        reportButton = new JButton("Display Report");
        reportButton.setBounds(238, 240, 144, 30);
        reportButton.addActionListener((ActionEvent actionEvent) -> {
            int last = AutoArray.size();
            int minusFive = AutoArray.size() - 5;
            if (last <= 5) {
                System.out.println(AutoArray.stream().map(i -> i.toString()).collect(Collectors.joining("")));
            } else {
                List<Automobile> AutoArr = AutoArray.subList(minusFive, last);
                System.out.println(AutoArr.stream().map(i -> i.toString()).collect(Collectors.joining("")));
            }
        });
        getContentPane().add(reportButton);
        
        answerField = new JTextField();
        answerField.setEditable(false);
        answerField.setBounds(238, 200, 144, 28);
        getContentPane().add(answerField);
        answerField.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Automobile Type", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(4, 72, 426, 104);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(6, 16, 414, 82);
        panel_1.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Miles per Gallon");
        lblNewLabel.setBounds(131, 9, 102, 14);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Weight in Pounds");
        lblNewLabel_1.setBounds(131, 54, 102, 14);
        panel.add(lblNewLabel_1);
        
        milesPerGallon = new JTextField();
        milesPerGallon.setBounds(242, 6, 136, 20);
        panel.add(milesPerGallon);
        milesPerGallon.setColumns(10);
        
        weightInPounds = new JTextField();
        weightInPounds.setBounds(243, 51, 135, 20);
        panel.add(weightInPounds);
        weightInPounds.setColumns(10);        
        
        hybridRadioButton = new JRadioButton("Hybrid");
        hybridRadioButton.setBounds(16, 5, 109, 23);
        hybridRadioButton.addActionListener((ActionEvent actionEvent) -> {
            milesPerGallon.setEditable(true);
            weightInPounds.setEditable(false);
            weightInPounds.setText(null);
        });
        panel.add(hybridRadioButton);
        
        electricRadioButton = new JRadioButton("Electric");
        electricRadioButton.setBounds(16, 31, 109, 23);
        electricRadioButton.addActionListener((ActionEvent actionEvent) -> {
            milesPerGallon.setEditable(false);
            weightInPounds.setEditable(true);
            milesPerGallon.setText(null);
        });
        panel.add(electricRadioButton);
        
        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBounds(16, 57, 109, 23);
        otherRadioButton.addActionListener((ActionEvent actionEvent) -> {
            milesPerGallon.setEditable(false);
            weightInPounds.setEditable(false);
            milesPerGallon.setText(null);
            weightInPounds.setText(null);
        });
        panel.add(otherRadioButton); 
        
        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(hybridRadioButton);
        groupButton.add(electricRadioButton);
        groupButton.add(otherRadioButton); 
        
        computeButton = new JButton("Compute Sales Tax");
        computeButton.setBounds(53, 199, 144, 30);
        computeButton.addActionListener(listenForButton);
        otherRadioButton.addActionListener(listenForButton);
        electricRadioButton.addActionListener(listenForButton);
        hybridRadioButton.addActionListener(listenForButton);
        getContentPane().add(computeButton);
     
    } // end constructor 
    
    // A method that will check to see if the data fields contain proper numbers.
    public int checkError(String number) {
        try {
            int numericValue = Integer.parseInt(number);
            if (numericValue <= 0) {
                numericValue = -1;
            }
            return numericValue;
        } catch (Exception exception) {
            return -1;
        }
    }
    
    // This class will listen for actions and handle them, specifically how the compute button is handled depending on the radio buttons.
    private class CheckButton implements ActionListener {     
        public void actionPerformed(ActionEvent e) {
            boolean comp = e.getSource() == computeButton;
            boolean other = otherRadioButton.isSelected();
            boolean ele = electricRadioButton.isSelected();
            boolean hyb = hybridRadioButton.isSelected();
            int numberOneIn = checkError(salesPriceField.getText());
            int numberTwoIn = checkError(weightInPounds.getText());
            int numberThreeIn = checkError(milesPerGallon.getText());
            
            if (comp && other) {
                if (numberOneIn != -1.0) {
                    Automobile car  = new Automobile (makeAndModelField.getText(), Integer.parseInt(salesPriceField.getText()));
                    answerField.setText("" + car.salesTax());
                    AutoArray.add(car);
                    } else {
                    JOptionPane.showMessageDialog(Project2.this, "Price must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                
            } else if (comp && ele) {
                if (numberTwoIn != -1.0 && numberOneIn != -1.0) {                    
                    Electric carList  = new Electric (Integer.parseInt(weightInPounds.getText()), makeAndModelField.getText(), Integer.parseInt(salesPriceField.getText()));
                    answerField.setText("" + carList.salesTax());
                    AutoArray.add(carList);
                    } else if (numberOneIn == -1.0) {
                        JOptionPane.showMessageDialog(Project2.this, "Price must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Project2.this, "Weight In Pounds must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                
            } else if (comp && hyb) {
                if (numberThreeIn != -1.0 && numberOneIn != -1.0) {                    
                    Hybrid carList  = new Hybrid (Integer.parseInt(milesPerGallon.getText()),makeAndModelField.getText(), Integer.parseInt(salesPriceField.getText()));
                    answerField.setText("" + carList.salesTax());
                    AutoArray.add(carList);
                    } else if (numberOneIn == -1.0) {
                        JOptionPane.showMessageDialog(Project2.this, "Price must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Project2.this, "Miles Per Gallon must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        
                    }
            }
        }
    } // end CheckButton
  
  // This is the main class which calls the GUI object and establishes parameters for it.
  public static void main (String args []) {       
      Project2 form = new Project2 (); 
      form.setTitle("Automobile Sales Tax Calculator");
      form.setVisible(true);
      form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
  } // end main  
} // end Project2