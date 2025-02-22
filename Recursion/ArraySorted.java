package Recursion;

import java.util.Scanner;

public class ArraySorted {
    // Check if array is sorted in increasing order
    static boolean isArraySortedInc(int arr[], int n) {
        if (n == 1) {
            return true;
        }
        return arr[n - 1] >= arr[n - 2] && isArraySortedInc(arr, n - 1);
    }

    // Check if array is sorted in decreasing order
    static boolean isArraySortedDec(int arr[], int n) {
        if (n == 1) {
            return true;
        }
        return arr[n - 1] <= arr[n - 2] && isArraySortedDec(arr, n - 1);
    }

    // Function to reverse the array using recursion
    static void reverseArray(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        // Swapping elements
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start + 1, end - 1);
    }

    // Function to print the array
    static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        // Taking user input for array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Checking if the array is sorted
        if (isArraySortedInc(arr, arr.length)) {
            System.out.println("The array is sorted in increasing order.");
        } else if (isArraySortedDec(arr, arr.length)) {
            System.out.println("The array is sorted in decreasing order.");
        } else {
            System.out.println("The array is not sorted.");
        }

        // Reversing the array using recursion
        reverseArray(arr, 0, size - 1);

        // Printing the reversed array
        System.out.println("Reversed array:");
        printArray(arr);

        scanner.close();
    }
}
