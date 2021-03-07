package weekSeven;

import java.util.ArrayList;

public class NonGenericClass {


    public static void main(String[] args) {
        ArrayList namesList = new ArrayList();
        namesList.add("John");
        namesList.add(12);
        namesList.add(12.43);
        namesList.add(true);
        System.out.println(namesList);
    }
}