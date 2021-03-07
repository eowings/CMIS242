package weekEight;
//////////////////////////////////////////////////////////
//File Name: Project4.java
//Author: Eddy Owings
//Date: 12/11/2020
//Description: A class that contains main method and
//creates a GUI
//////////////////////////////////////////////////////////
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Project4 extends JFrame {    
    private JTextField textFieldTransactionNo;
    private JTextField textFieldAddress;
    private JTextField textFieldBedrooms;
    private JTextField textFieldSquareFootage;
    private JTextField textFieldPrice;
    // Database of property records
    TreeMap<Integer, Property<Status>> propertyTreeMap = new TreeMap<>();
    
    //Main Method
    public static void main(String[] args) {        
        Project4 frame = new Project4();
        frame.setVisible(true);
        frame.setSize(380, 280);
    }//End Main
    
    public Project4() {
        setTitle("Real Estate Database");
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lbltransactionNo = new JLabel("Transaction No:");
        lbltransactionNo.setBounds(10, 11, 124, 21);
        getContentPane().add(lbltransactionNo);
        
        textFieldTransactionNo = new JTextField();
        textFieldTransactionNo.setBounds(167, 11, 183, 21);
        getContentPane().add(textFieldTransactionNo);
        textFieldTransactionNo.setColumns(10);
        
        textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(167, 43, 183, 21);
        getContentPane().add(textFieldAddress);
        
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 43, 124, 21);
        getContentPane().add(lblAddress);
        
        textFieldBedrooms = new JTextField();
        textFieldBedrooms.setColumns(10);
        textFieldBedrooms.setBounds(167, 75, 183, 21);
        getContentPane().add(textFieldBedrooms);
        
        JLabel lblBedrooms = new JLabel("Bedrooms:");
        lblBedrooms.setBounds(10, 75, 124, 21);
        getContentPane().add(lblBedrooms);
        
        textFieldSquareFootage = new JTextField();
        textFieldSquareFootage.setColumns(10);
        textFieldSquareFootage.setBounds(167, 107, 183, 21);
        getContentPane().add(textFieldSquareFootage);
        
        JLabel lblSquareFootage = new JLabel("Square Footage:");
        lblSquareFootage.setBounds(10, 107, 124, 21);
        getContentPane().add(lblSquareFootage);
        
        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(167, 139, 183, 21);
        getContentPane().add(textFieldPrice);
        
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(10, 139, 124, 21);
        getContentPane().add(lblPrice);
        
        JButton btnProcess = new JButton("Process");
        btnProcess.setBounds(10, 171, 124, 23);
        getContentPane().add(btnProcess);
        
        JButton btnChangeStatus = new JButton("Change Status");
        btnChangeStatus.setBounds(10, 205, 124, 23);
        getContentPane().add(btnChangeStatus);
        
        String[] processOptions = {"Insert", "Delete", "Find"};
        JComboBox comboBoxProcess = new JComboBox(processOptions);
        comboBoxProcess.setBounds(167, 171, 183, 22);
        getContentPane().add(comboBoxProcess);
        
        Status[] changeStatusOptions = {Status.FOR_SALE, Status.UNDER_CONTRACT, Status.SOLD};
        JComboBox comboBoxChangeStatus = new JComboBox(changeStatusOptions);
        comboBoxChangeStatus.setBounds(167, 205, 183, 22);
        getContentPane().add(comboBoxChangeStatus);
        
        //process Listener
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String processOpt = String.valueOf(comboBoxProcess.getSelectedItem());
                try { 
                    switch (processOpt) { 
                    case "Insert":
                        checkDuplicate(getTransactionId()); 
                        propertyTreeMap.put(getTransactionId(), getPropertyInfo()); 
                        JOptionPane.showMessageDialog(null, "Property successfully inserted in database");
                        break;
                    case "Delete":
                        checkExists(getTransactionId()); 
                        propertyTreeMap.remove(getTransactionId()); 
                        JOptionPane.showMessageDialog(null, "Property successfully deleted from database");
                        break;
                    case "Find":
                        checkExists(getTransactionId()); 
                        Property<Status> getProperty = propertyTreeMap.get(getTransactionId()); 
                        JOptionPane.showMessageDialog(null, getProperty.toString()); 
                        break;
                    }                    
                } catch(NumberFormatException nfe) { 
                    JOptionPane.showMessageDialog(null, "Incorrect number format. Please enter integers");
                } catch(DuplicateProperty dp) { 
                    JOptionPane.showMessageDialog(null, "Transaction ID already exists. Please enter new ID");
                } catch(NotFound nf) { 
                    JOptionPane.showMessageDialog(null, "Transaction ID does not exist. Please enter new ID");
                }
            }
        });//End process Listener
        
        //changeStatus Listener
        btnChangeStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {               
                try { 
                    Status statusOption = (Status)comboBoxChangeStatus.getSelectedItem(); 
                    checkExists(getTransactionId()); 
                    Property<Status> chgProperty = propertyTreeMap.get(getTransactionId());
                    chgProperty.changeState(statusOption); 
                    propertyTreeMap.put(getTransactionId(), chgProperty);                     
                    JOptionPane.showMessageDialog(null, "Property status changed in database");
                } catch(NumberFormatException nfe) { 
                    JOptionPane.showMessageDialog(null, "Incorrect number format. Please enter integers");
                } catch(NotFound nf) {
                    JOptionPane.showMessageDialog(null, "Transaction ID does not exist. Please enter new ID");
                }
            }
        }); //End changeStatus Listener
    }// End Constructor
    
    private Property<Status> getPropertyInfo() throws NumberFormatException {
        String address = textFieldAddress.getText();
        int bedrooms = Integer.parseInt(textFieldBedrooms.getText());
        int sqFt = Integer.parseInt(textFieldSquareFootage.getText());
        int price = Integer.parseInt(textFieldPrice.getText());
        return new Property<>(address, bedrooms, sqFt, price);
    }      
    private int getTransactionId() throws NumberFormatException {
            return Integer.parseInt(textFieldTransactionNo.getText());
    }
    private void checkDuplicate(int transactionId) throws DuplicateProperty {
        if(propertyTreeMap.containsKey(transactionId)) {
            throw new DuplicateProperty();
        }
    }
    private void checkExists(int transactionId) throws NotFound {
        if(!propertyTreeMap.containsKey(transactionId)) {
            throw new NotFound();
        }
    }
    private class DuplicateProperty extends Exception {
        public DuplicateProperty() {
            super();
        }
    }
    private class NotFound extends Exception {
        public NotFound() {
            super();
        }         
    }
    
}// End Project4 Class
