
package week1.day2;

public class isPrime {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6};
        
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.println("Number " + number + " is prime.");
            } else {
                System.out.println("Number " + number + " is not prime.");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
