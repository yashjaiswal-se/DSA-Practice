package Recursion;

import java.util.Scanner;

public class Factorial {
    // Factorial using Recursion
    static int getFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    // Recursive function to calculate the nth Fibonacci number
    static int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    // Recursive function to find the sum of the first n Fibonacci numbers
    static int getFibonacciSum(int n) {
        if (n == 0) {
            return 0;
        }
        return getFibonacci(n) + getFibonacciSum(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Factorial input
        System.out.print("Enter a number to find factorial: ");
        int factNum = scanner.nextInt();
        int fact = getFactorial(factNum);
        System.out.println("The factorial of " + factNum + " is: " + fact);

        // Fibonacci sum input
        System.out.print("Enter a number to find Fibonacci sum: ");
        int fibNum = scanner.nextInt();
        int sum = getFibonacciSum(fibNum);
        System.out.println("The sum of first " + fibNum + " Fibonacci numbers is: " + sum);

        scanner.close();
    }
}
