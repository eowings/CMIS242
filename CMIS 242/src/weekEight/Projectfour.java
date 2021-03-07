package weekEight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class Projectfour {
    public static void main(String[] args) {
        // Create new JFrame
        JFrame p4 = new JFrame("Real Estate Database");
        // Set Size of JFrame
        p4.setSize(400, 300);
        // Default close action
        p4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add Project4GUI JPanel to JFrame
        p4.add(new Project4GUI());
        // Make JFrame visible
        p4.setVisible(true);
    }
    private static class Project4GUI extends JPanel {
        // Create JLabels
        private JLabel transactionNoLbl = new JLabel("Transaction No:");
        private JLabel addressLbl = new JLabel("Address:");
        private JLabel numBedroomsLbl = new JLabel("Bedrooms:");
        private JLabel sqFtLbl = new JLabel("Square Footage:");
        private JLabel priceLbl = new JLabel("Price");
        // Create JTextFields
        private JTextField transactionNoField = new JTextField();
        private JTextField addressField = new JTextField();
        private JTextField bedroomsField = new JTextField();
        private JTextField sqFtField = new JTextField();
        private JTextField priceField = new JTextField();
        // Create JButtons
        private JButton processBtn = new JButton("Process");
        private JButton chgStatusBtn = new JButton("Change Status");
        // Create Arrays and ComboBoxes
        private String[] dbAction = {"Insert", "Delete", "Find"};
        private JComboBox<String> dbActionCombo = new JComboBox<>(dbAction);
        private Status[] status = {Status.FOR_SALE, Status.UNDER_CONTRACT, Status.SOLD};
        private JComboBox<Enum<Status>> statusCombo = new JComboBox<>(status);
        // TreeMap database of property records with the transaction number field
        // as the key and a Property object as the value
        TreeMap<Integer, Property<Status>> propertyTreeMap = new TreeMap<>();
        // Project4GUI constructor
        
        public Project4GUI() {
            // GridLayout
            setLayout(new GridLayout(7, 2, 7, 10));
            setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
            // Add elements to GridLayout
            this.add(transactionNoLbl);
            this.add(transactionNoField);
            this.add(addressLbl);
            this.add(addressField);
            this.add(numBedroomsLbl);
            this.add(bedroomsField);
            this.add(sqFtLbl);
            this.add(sqFtField);
            this.add(priceLbl);
            this.add(priceField);
            this.add(processBtn);
            this.add(dbActionCombo);
            this.add(chgStatusBtn);
            this.add(statusCombo);

            // New action listener for Process Button
            processBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // Variables
                    String processOpt = String.valueOf(dbActionCombo.getSelectedItem());
                    try { // Try-catch exceptions
                        switch (processOpt) { // Switch-Case for different options in dbActionCombo
                        case "Insert":
                            checkDups(getTransactionId()); // Checks for duplicates before insert
                            propertyTreeMap.put(getTransactionId(), getPropertyInfo()); // Inserts ID and Property into TreeMap
                            // JOptionPane notification
                            JOptionPane.showMessageDialog(null, "Property successfully inserted in database");
                            break;
                        case "Delete":
                            checkExists(getTransactionId()); // Checks if ID exists before deletion
                            propertyTreeMap.remove(getTransactionId()); // Removes ID and Property from TreeMap
                            JOptionPane.showMessageDialog(null, "Property successfully deleted from database");
                            break;
                        case "Find":
                            checkExists(getTransactionId()); // Checks if ID exists
                            Property<Status> getProperty = propertyTreeMap.get(getTransactionId()); // Creates property object
                            JOptionPane.showMessageDialog(null, getProperty.toString()); // Displays Property object if found
                            break;
                        }
                    } catch(NumberFormatException nfe) { // Catch NumberFormatException
                        JOptionPane.showMessageDialog(null, "Incorrect format for Transaction ID. Please enter integers");
                    } catch(DupProperty dp) { // Catch custom DupProperty exception
                        JOptionPane.showMessageDialog(null, "Transaction ID already exists. Please enter new ID");
                    } catch(NotFound nf) { // Catch custom NotFound exception
                        JOptionPane.showMessageDialog(null, "Transaction ID does not exist. Please enter new ID");
                    }
                }
            });
            // New action listener for Change Status button
            chgStatusBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // Variables
                    try { // Try-catch for exceptions
                        Status statusOption = (Status)statusCombo.getSelectedItem(); // Create status object
                        checkExists(getTransactionId()); // Call checkExists method with transactionId
                        Property<Status> chgProperty = propertyTreeMap.get(getTransactionId()); // Create property object
                        chgProperty.changeState(statusOption); // Change state method of property object
                        propertyTreeMap.put(getTransactionId(), chgProperty); // Put new property in TreeMap
                        // JOptionPane for notifications
                        JOptionPane.showMessageDialog(null, "Property status changed in database");
                    } catch(NumberFormatException nfe) { // Catch block for exceptions
                        JOptionPane.showMessageDialog(null, "Incorrect format for Transaction ID. Please enter integers");
                    } catch(NotFound nf) {
                        JOptionPane.showMessageDialog(null, "Transaction ID does not exist. Please enter new ID");
                    }
                }
            });
        }

        // Method to retrieve property info, throws NumberFormatException
        private Property<Status> getPropertyInfo() throws NumberFormatException {
            String address = addressField.getText();
            int bedrooms = Integer.parseInt(bedroomsField.getText());
            int sqFt = Integer.parseInt(sqFtField.getText());
            int price = Integer.parseInt(priceField.getText());
            return new Property<>(address, bedrooms, sqFt, price);
        }
        // Method to getTransactionId, eliminates duplicate code
        private int getTransactionId() throws NumberFormatException {
            return Integer.parseInt(transactionNoField.getText());
        }
        // Method to check for duplicates, throws DupProperty exception
        private void checkDups(int transactionId) throws DupProperty {
            if(propertyTreeMap.containsKey(transactionId)) {
                throw new DupProperty();
            }
        }
        // Method to check if Id exists, throws NotFound exception
        private void checkExists(int transactionId) throws NotFound {
            if(!propertyTreeMap.containsKey(transactionId)) {
                throw new NotFound();
            }
        }
        // Defines DupProperty exception
        private class DupProperty extends Exception {
            public DupProperty() {
                super();
            }
        }
        // Defines NotFound exception
        private class NotFound extends Exception {
            public NotFound() {
                super();
            }
        }        
    }    
}
