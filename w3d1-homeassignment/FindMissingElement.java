package Week3;

import java.util.HashSet;
import java.util.Set;

public class FindMissingElement {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 10, 6, 8 };

        // Find the maximum and minimum values in the array
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        // Store array elements in a HashSet for quick lookup
        Set<Integer> arrayElements = new HashSet<>();
        for (int num : arr) {
            arrayElements.add(num);
        }

        // Find and print the missing elements in the sequence
        System.out.print("Missing elements: ");
        for (int i = min; i <= max; i++) {
            if (!arrayElements.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
