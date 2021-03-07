package weekFour;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ProgramCore extends JFrame {

    // Build GUI
    JLabel makeAndModelLabel, salesPriceLabel;
    JTextField makeAndModel, salesPrice;

    JPanel top, middle, bottom;

    JRadioButton hybrid, electric, other;
    ButtonGroup group;

    JLabel mileageLabel, weightLabel;
    JTextField mileage, weight;

    JButton computeSalesTax, clearFields, displayReport;
    JLabel output;

    //List of Automobile
    List<Automobile> autoMobiles;

    ProgramCore() {
        autoMobiles = new ArrayList<>();
        //initialize all components
        setTitle("Automobile Sales Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600, 450);
        setVisible(true);

        top = new JPanel(new GridLayout(2, 2, 10, 10));
        middle = new JPanel(new GridLayout(3, 3, 10, 10));
        middle.setBorder(BorderFactory.createTitledBorder("Automobile Type"));
        bottom = new JPanel(new GridLayout(2, 2, 10, 10));

        // Prepare and create contents of the top part of frame
        makeAndModelLabel = new JLabel("Make and Model");
        salesPriceLabel = new JLabel("Sales Price");
        makeAndModel = new JTextField(20);
        salesPrice = new JTextField(20);
        top.add(makeAndModelLabel);
        top.add(makeAndModel);
        top.add(salesPriceLabel);
        top.add(salesPrice);

        // Prepare and create contents of the middle part of frame
        hybrid = new JRadioButton("Hybrid");
        electric = new JRadioButton("Electric");
        other = new JRadioButton("Other");
        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(hybrid);
        groupButton.add(electric);
        groupButton.add(other);

        mileageLabel = new JLabel("Miles per Gallon");
        weightLabel = new JLabel("Weight in Pounds");
        mileage = new JTextField(20);
        weight = new JTextField(20);

        middle.add(hybrid);
        middle.add(mileageLabel);
        middle.add(mileage);
        middle.add(electric);
        middle.add(weightLabel);
        middle.add(weight);
        middle.add(other);

        // Prepare and create contents for the bottom part of frame
        computeSalesTax = new JButton("Compute Sales tax");
        clearFields = new JButton("Clear Fields");
        displayReport = new JButton("Display Report");

        output = new JLabel("");
        output.setBorder(BorderFactory.createLineBorder(new Color(132, 141, 149), 1));

        bottom.add(computeSalesTax);
        bottom.add(output);
        bottom.add(clearFields);
        bottom.add(displayReport);

        top.setBounds(80, 30, 400, 50);
        middle.setBounds(10, 100, 550, 120);
        bottom.setBounds(60, 250, 400, 80);
        add(top);
        add(middle);
        add(bottom);

        // Actionlistener for 3 buttons and 3 radio buttons
        computeSalesTax.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                if(other.isSelected()) {
                    saveOtherReport();
                }
                else if(hybrid.isSelected()) {
                    saveHybridReport();
                }
                else {
                    saveElectricReport();
                }
            }
        });

        clearFields.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent actionEvent){
                resetForm();
            }
        });

        displayReport.addActionListener((ActionEvent actionEvent) -> {
            displayReports();
        });

        other.addActionListener((ActionEvent actionEvent) -> {
            mileage.setEnabled(false);
            weight.setEnabled(false);
            output.setText("");
            mileage.setText("");
            weight.setText("");
            saveOtherReport();

        });

        hybrid.addActionListener((ActionEvent actionEvent) -> {
            mileage.setEnabled(true);
            weight.setEnabled(false);
            output.setText("");
            weight.setText("");
            saveHybridReport();
        });

        electric.addActionListener((ActionEvent actionEvent) -> {
            mileage.setEnabled(false);
            weight.setEnabled(true);
            mileage.setText("");
            output.setText("");
            saveElectricReport();
        });

        output.setEnabled(false);
        other.doClick();
        output.setForeground(Color.GRAY);
        output.setFont(new Font(Font.SERIF, Font.BOLD, 15));
    }


    /* Method validate input number if it is invalid (<=0), return -1
     */
    public int validateInput(String number) {
        try {
            int priceValue = Integer.parseInt(number);
            if (priceValue <= 0) {
                priceValue = -1;
            }
            return priceValue;
        } catch (Exception exception) {
            return -1;
        }
    }

    // Method that adds automobile objects to the array
    public void addToList(Automobile mobile) {
        if (autoMobiles.size() < 5) {
            autoMobiles.add(mobile);
        } else {
            autoMobiles.remove(0);
            autoMobiles.add(mobile);
        }
    }

    /**
     * Method that checks if the entered data is valid for given class Other
     * type and calculates the tax and adds to the Array . finally sets the
     * sales tax to output label.
     *
     * if not valid it displays error msgg.
     */
    public void saveOtherReport() {
        int price = validateInput(salesPrice.getText());
        if (price != -1.0) {
            Automobile mobile = new Automobile(makeAndModel.getText(), price);
            output.setText("" + mobile.salesTax());
            addToList(mobile);
        } else {
            JOptionPane.showMessageDialog(this, "Price must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method that checks if the entered data is valid for given class
     * Hybrid type and calculates the tax and adds to the Array . finally
     * sets the sales tax to output label.
     */
    public void saveHybridReport() {
        int price = validateInput(salesPrice.getText());
        if (price != -1) {
            int mileageValue = validateInput(mileage.getText());
            if (mileageValue != -1) {
                Hybrid mobile = new Hybrid(price, makeAndModel.getText(), mileageValue);
                output.setText("" + mobile.salesTax());
                addToList(mobile);
            }
            else {
                JOptionPane.showMessageDialog(this, "Miles Per Gallon must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Price mus be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method that checks if the entered data is valid for given class
     * Electric type and calculates the tax and adds to the Array . finally
     * sets the sales tax to output label.
     */
    public void saveElectricReport() {
        int price = validateInput(salesPrice.getText());
        if (price != -1.0) {
            Integer weightValue = validateInput(weight.getText());
            if (weightValue != -1) {
                Electric mobile = new Electric(price, makeAndModel.getText(), weightValue);
                output.setText("" + mobile.salesTax());
                addToList(mobile);
            }
            else {
                JOptionPane.showMessageDialog(this, "Weight must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Price must be a valid integer.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void resetForm() {
        makeAndModel.setText("");
        salesPrice.setText("");
        mileage.setText("");
        weight.setText("");
        other.setSelected(true);
        output.setText("");
        other.doClick();
    }

    public void displayReports() {
        String result = "";
        for (Automobile mobile : autoMobiles) {
            result += mobile + "";
        }
        JOptionPane.showMessageDialog(this, result, "Auto Mobiles Report", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(result);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new ProgramCore();
            }
        });
    } 
}// end public static class ProgramCore