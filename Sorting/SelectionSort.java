package Sorting;

import java.util.Scanner;

public class SelectionSort {
    static void selectionSortAscending(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    static void selectionSortDescending(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
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

        selectionSortAscending(arr, n);

        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("");
        selectionSortDescending(arr, n);

        System.out.println("Sorted array in descending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
