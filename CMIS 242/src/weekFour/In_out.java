package weekFour;
// Week 4 Discussion: Ranti Ajitaramu

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

class In_out extends JFrame implements ActionListener {
    Frame f = new Frame();
    Label input1 = new Label("Enter a Number");
    Label input2 = new Label("Enter a Number");
    Label output = new Label("Output");
    TextField text1 = new TextField();
    TextField text2 = new TextField();
    TextField text3 = new TextField();
    Button button1 = new Button("Add");
    Button button2 = new Button("Cancel");
    In_out() {
        input1.setBounds(30,70,100,20);
        input2.setBounds(30,100,100,20);
        output.setBounds(30,130,100,20);
        text1.setBounds(150,70,100,20);
        text2.setBounds(150,100,100,20);
        text3.setBounds(150,130,100,20);
        text3.setEditable(false);
        button1.setBounds(50,170,50,20);
        button2.setBounds(200,170,50,20);
             
        f.add(input1);
        f.add(input2);
        f.add(output);
        f.add(text1);
        f.add(text2);
        f.add(text3);
        f.add(button1);
        f.add(button2);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
             
        f.setLayout(null);
        f.setSize(300,250);
        f.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button2) {
            System.exit(0);
        }
        int n1=Integer.parseInt(text1.getText());
        int n2=Integer.parseInt(text2.getText());
        
        if(e.getSource()==button1) {
            text3.setText(String.valueOf(n1+n2));
        }          
    }
    
    public static void main(String... s) {
        new In_out();
    }
}
