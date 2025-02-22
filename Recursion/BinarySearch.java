package Recursion;

import java.util.Scanner;

public class BinarySearch {
    // Recursive Binary Search function
    static boolean binarySearch(int arr[], int si, int ei, int key) {
        if (si > ei) {
            return false; // Base case: element not found
        }

        int mid = si + (ei - si) / 2; // Correct calculation of mid

        if (arr[mid] == key) {
            return true; // Key found
        } else if (key > arr[mid]) {
            return binarySearch(arr, mid + 1, ei, key); // Search in right half
        } else {
            return binarySearch(arr, si, mid - 1, key); // Search in left half
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        System.out.println("Element should be entered in their increasing order.");
        // Taking user input for sorted array elements
        System.out.println("Enter " + size + " sorted elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking user input for the search key
        System.out.print("Enter the key to search: ");
        int key = scanner.nextInt();

        // Performing binary search
        boolean found = binarySearch(arr, 0, size - 1, key);

        // Printing result
        if (found) {
            System.out.println("Key  is present in the array.");
        } else {
            System.out.println("Key  is NOT present in the array.");
        }

        scanner.close();
    }
}
