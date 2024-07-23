package week1.day2;

import java.util.Scanner;

public class isPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String original = input.nextLine();

        // Remove spaces and convert to lowercase for case insensitive comparison
        String processed = original.replaceAll("\\s+", "").toLowerCase();

        // Reverse the processed string
        String reversed = new StringBuilder(processed).reverse().toString();

        // Check if the original processed string is equal to the reversed string
        if (processed.equals(reversed)) {
            System.out.println("The given user input \"" + original + "\" is a palindrome");
        } else {
            System.out.println("The given user input \"" + original + "\" is not a palindrome");
        }

        input.close();
    }
}
