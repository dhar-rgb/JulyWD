package Week3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class IntersectionOFnumbersUsingList {

    public static void main(String[] args) {
        // Declare and initialize the lists with the given values
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(11);
        list1.add(4);
        list1.add(6);
        list1.add(7);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(8);
        list2.add(4);
        list2.add(9);
        list2.add(7);

        // Find the intersection of the two lists
        List<Integer> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);

        // Print the intersection
        System.out.println("Intersection of the lists: " + intersection);
    }
}
