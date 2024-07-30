package Week3;

import java.util.ArrayList;
import java.util.List;

public class reverseTheArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("HCL");
        list.add("Wipro");
        list.add("Aspire Systems");
        list.add("CTS");

        // Print the elements in the required order
        System.out.println("Elements in the required order: ");
        System.out.println(list.get(1));  // Wipro
        System.out.println(list.get(0));  // HCL
        System.out.println(list.get(3));  // CTS
        System.out.println(list.get(2));  // Aspire Systems
    }
}
