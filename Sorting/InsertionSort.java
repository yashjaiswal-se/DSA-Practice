package Sorting;

import java.util.Scanner;

public class InsertionSort {
    static void insertionSortAscending(int arr[], int n) {
        for (int i = 1; i < n; i++) { // Assume the first element is already sorted
            int curr = arr[i];
            int prev = i - 1;

            // Shift elements to the right to create space for curr
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    static void insertionSortDescending(int arr[], int n) {
        for (int i = 1; i < n; i++) { // Assume the first element is already sorted
            int curr = arr[i];
            int prev = i - 1;

            // Shift elements to the right to create space for curr
            while (prev >= 0 && arr[prev] < curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSortAscending(arr, n);

        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        insertionSortDescending(arr, n);

        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
