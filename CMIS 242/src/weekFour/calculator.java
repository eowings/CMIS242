package weekFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculator extends JFrame implements ActionListener {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Container con = getContentPane();
    JLabel prompt = new JLabel("Type first number");
    JLabel prompt2 = new JLabel("Type second number and press a button");
    JLabel result = new JLabel();
    Font promptFont = new Font("Times", Font.BOLD, 12);
    Font resultFont = new Font("Times", Font.BOLD, 20);
    
    JTextField input = new JTextField(20);
    JTextField input2 = new JTextField(20);
    
    JButton add = new JButton("add");
    JButton subtract = new JButton("subtract");
    JButton multiply = new JButton("multiply");
    JButton divide = new JButton("divide");

    
    public calculator(){
        
        super("Calculator");
        setSize(300,300);
        con.setLayout(new FlowLayout());
        prompt.setFont(promptFont);
        prompt2.setFont(promptFont);
        result.setFont(resultFont);
        
        con.add(prompt);
        con.add(input);
        con.add(prompt2);
        con.add(input2);
        con.add(add);
        con.add(subtract);
        con.add(multiply);
        con.add(divide);
        con.add(result);
    
    
        
        //action listeners
        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        
        
    }
    
    public static void main(String[] args){
        
        calculator demo = new calculator();
        demo.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        if(source == add)
        {
            String ans1 = input.getText();
            int num1 = Integer.parseInt(ans1);
            String ans2 = input2.getText();
            int num2 = Integer.parseInt(ans2);  
            
            int RESULT = num1 + num2;
            String res = new Integer(RESULT).toString();
            result.setText("The result is equal to " + res);
            
                
        }
        
        if(source == subtract)
        {
            String ans1 = input.getText();
            int num1 = Integer.parseInt(ans1);
            String ans2 = input2.getText();
            int num2 = Integer.parseInt(ans2);  
            
            int RESULT = num1 - num2;
            String res = new Integer(RESULT).toString();
            result.setText("The result is equal to " + res);    
        }
        
        if(source == multiply)
        {
            String ans1 = input.getText();
            int num1 = Integer.parseInt(ans1);
            String ans2 = input2.getText();
            int num2 = Integer.parseInt(ans2);  
            
            int RESULT = num1 * num2;
            String res = new Integer(RESULT).toString();
            result.setText("The result is equal to " + res);
        }
        
        if(source == divide)
        {
            String ans1 = input.getText();
            double num1 = Double.parseDouble(ans1);
            String ans2 = input2.getText();
            double num2 = Double.parseDouble(ans2); 
            
            Double RESULT = num1 / num2;
            String res = new Double(RESULT).toString();
            result.setText("The result is equal to " + res);        
        }
        
    }

}