package weekFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeekFourDiscussion extends JFrame {     
    private 
    JTextField oneField;
    JTextField twoField;
    JTextField answerField;
    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    
   
    public WeekFourDiscussion () {     
        setMinimumSize(new Dimension(400, 200));
        getContentPane().setLayout(null);
        
        // Set editable fields and labels        
        JLabel description = new JLabel("Enter a number in each box below, then select any button.");
        description.setBounds(10, 0, 364, 14);
        getContentPane().add(description);
        
        JLabel oneFieldLabel = new JLabel("Number One");
        oneFieldLabel.setBounds(10, 25, 76, 14);
        getContentPane().add(oneFieldLabel);
        
        oneField = new JTextField();
        oneField.setBounds(10, 41, 76, 20);
        getContentPane().add(oneField);
        oneField.setColumns(10);
    
        JLabel twoFieldLabel = new JLabel("Number Two");
        twoFieldLabel.setBounds(96, 25, 87, 14);
        getContentPane().add(twoFieldLabel);
    
        twoField = new JTextField();
        twoField.setBounds(96, 41, 76, 20);
        getContentPane().add(twoField);
        twoField.setColumns(10);        
        
        // Set buttons
        CheckButton listenForButton = new CheckButton();
        
        addButton = new JButton("Add");
        addButton.setBounds(10, 72, 89, 23);
        addButton.addActionListener(listenForButton);
        getContentPane().add(addButton);
        
        subtractButton = new JButton("Subtract");
        subtractButton.setBounds(109, 72, 89, 23);
        subtractButton.addActionListener(listenForButton);
        getContentPane().add(subtractButton);
        
        multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(208, 72, 89, 23);
        multiplyButton.addActionListener(listenForButton);
        getContentPane().add(multiplyButton);
        
        // Set un-editable field and label
        JLabel answerFieldLabel = new JLabel("Answer");
        answerFieldLabel.setBounds(10, 116, 46, 14);
        getContentPane().add(answerFieldLabel);      
        
        answerField = new JTextField();
        answerField.setEditable(false);
        answerField.setBounds(10, 131, 314, 20);
        getContentPane().add(answerField);
        answerField.setColumns(10);        
        
    } // end constructor 
    
    private class CheckButton implements ActionListener {     
        public void actionPerformed(ActionEvent e) {
            double numberOneIn = Double.parseDouble(oneField.getText());
            double numberTwoIn = Double.parseDouble(twoField.getText());            
            if(e.getSource() == addButton) {
                answerField.setText("" + (numberOneIn + numberTwoIn));                
            } else if (e.getSource() == subtractButton) { 
                answerField.setText("" + (numberOneIn - numberTwoIn));
            } else if (e.getSource() == multiplyButton) {
                answerField.setText("" + (numberOneIn * numberTwoIn));
            }           
        }        
    } // end CheckButton
    
  public static void main (String args []) {        
    
      WeekFourDiscussion form = new WeekFourDiscussion (); 
      form.setTitle("Owings Week 4 Discussion");
      form.setSize(400,200);
      form.setVisible(true);
      form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
  } // end main  
} // end WeekFourDiscussion