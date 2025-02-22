package BitManipulation;

import java.util.Scanner;

public class Swapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        // First approach: Using a Temporary Variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("\n[Using Temporary Variable]");
        System.out.println("After swap: a = " + a + ", b = " + b);

        // uses extra memory

        // Second approach: Using Arithmetic Operations
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("\n[Using Arithmetic Operations]");
        System.out.println("After swap: a = " + a + ", b = " + b);

        // efficient use of memory

        // Third approach: Using Bitwise XOR (^)
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("\n[Using Bitwise XOR (^)]");
        System.out.println("After swap: a = " + a + ", b = " + b);

        // no need of extra memory+ efficient and faster operation

        // Closing scanner
        scanner.close();
    }
}
