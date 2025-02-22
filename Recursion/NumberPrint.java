package Recursion;

import java.util.Scanner;

public class NumberPrint {
    static void reverseSeries(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        reverseSeries(n - 1);
    }

    static void seriesForward(int n) {
        if (n == 0) {
            return;
        }
        seriesForward(n - 1);
        System.out.print(n + " ");
    }

    static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number for reverse series: ");
        int revNum = scanner.nextInt();
        reverseSeries(revNum);
        System.out.println();

        System.out.print("Enter a number for forward series: ");
        int forNum = scanner.nextInt();
        seriesForward(forNum);
        System.out.println();

        System.out.print("Enter a number to calculate sum from 1 to n: ");
        int sumNum = scanner.nextInt();
        int sum = getSum(sumNum);
        System.out.println("Sum from 1 to " + sumNum + " is: " + sum);

        scanner.close();
    }
}
