package BitManipulation;

import java.util.*;

public class BitStatus {
    public static void main(String[] args) {
        // We want to check if our i-th bit (from end) is set or not for a number
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.println("Please enter the number:");
        int n = sc.nextInt();
        System.out.println("Please enter the bit position to check (starting from 0):");
        int i = sc.nextInt();

        // Brute-force approach: Convert number to binary manually
        String str = "";
        int copy = n;

        // Convert number to binary string
        while (copy > 0) {
            if (copy % 2 == 1) {
                str = "1" + str; // Prepend "1" to maintain correct order
            } else {
                str = "0" + str; // Prepend "0"
            }
            copy = copy / 2; // Reduce number by dividing by 2
        }

        // Edge case: If number is 0, set binary string as "0"
        if (str.isEmpty()) {
            str = "0";
        }

        System.out.println("Binary representation: " + str);

        // Checking if the i-th bit from the right is set or not
        if (i >= str.length()) {
            System.out.println("Invalid bit position! The number doesn't have " + i + " bits.");
        } else {
            char bit = str.charAt(str.length() - 1 - i);
            System.out.println("The " + i + "-th bit from the right is: " + bit);
        }

        // Efficient method
        if ((n & (1 << i)) != 0) {
            System.out.println("Using Bit Manipulation: The " + i + "-th bit is SET (1).");
        } else {
            System.out.println("Using Bit Manipulation: The " + i + "-th bit is NOT set (0).");
        }

        // Another way
        if (((n >> i) & 1) != 0) {
            System.out.println("Using Right Shift: The " + i + "-th bit is SET (1).");
        } else {
            System.out.println("Using Right Shift: The " + i + "-th bit is NOT set (0).");
        }

        sc.close();
    }
}
