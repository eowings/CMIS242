package weekTwo;
//////////////////////////////////////////////////////////
//File Name: Project1.java
//Author: Eddy Owings
//Date: 10/31/2020
//Description: A class that will display the smallest
//largest and average weights from a selected file.
//////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Project1 {
    static Weight[] array = new Weight[1000];
    static int i = 0;
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            BufferedReader weightData = new BufferedReader(new FileReader
                                                          (chooser.getSelectedFile()));
            String eachLine;
            while ((eachLine = weightData.readLine()) !=null) {
                String[] parts = eachLine.split(" ");                
                int lbs = Integer.parseInt(parts[0]);
                double oz = Double.parseDouble(parts[1]);
                array[i] = new Weight(lbs, oz);
                i++;
            }
            weightData.close();
            if (i > 25) {
                System.out.println("ERROR: The File "  + 
                                   chooser.getSelectedFile().getName() + 
                                   " has exceed 25 total weights");
                System.exit(0);
            }           
        }
        // Display Smallest, Largest, and Average weights
        System.out.println("The smallest weight in the array is: " + findMinimum(array, i).toString());
        System.out.println("The largest weight in the array is: " + findMaximum(array, i).toString());
        System.out.println("The average weight for the array is: " + findAverage(array, i).toString());
        

    }// End Main 
    
    // Three private Project1 methods    
    // Find Smallest Number
    private static Weight findMinimum(Weight[] array, int size) {
        Weight min = array[0];
        for(int i = 1; i < size; i++) {
            if(!(min.lessThan(array[i]))) {
                min = array[i];
            }
        }
        return min;        
    }    
    // Find Largest Number
    private static Weight findMaximum(Weight[] array, int size) {
        Weight max = array[0];
        for(int i = 1; i < size; i++) {
            if(max.lessThan(array[i])) {
                max = array[i];
            }
        }
        return max;
    }    
    // Add All Numbers and Divide for Average
    private static Weight findAverage(Weight[] array, int size) {
        Weight avg = array[0];
        for(int i = 1; i < size; i++) {
            avg.addTo(array[i]);
        }
        avg.divide(size);
        return avg;
    }
}// End Project1
