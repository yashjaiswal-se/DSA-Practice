import java.util.*;
import java.util.Scanner;

public class BasicProblems {
    // Method to count the number of occurence of elements
    public static void countOccurence(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        System.out.println("Number of times " + target + " occurs in our array is " + count);
    }

    // Method to find last occurence
    public static void findLastOccurence(int[] arr, int target) {
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                lastIndex = i;
            }
        }
        if (lastIndex == -1) {
            System.out.println("Target is not present in array");
        } else {
            System.out.println("Target appears for the last time in the array at position " + (lastIndex + 1));
        }
    }

    // Method to count the number of occurence of elements
    public static void countGreaterElements(int[] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                count++;
            }
        }
        System.out.println("Number of elements greater than our target " + target + " is " + count);
    }

    // Method to check if array is sorted or not
    public static boolean checkSorted(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to sort a array
    public static void sortArrayDescending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    }

    // Method to return kth largest and kth smallest element
    public static int[] shortetAndLargestElement(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = { arr[0 + (k - 1)], arr[arr.length - k] };
        return ans;
    }

    // Method to print Array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element at index " + (i + 1));
            arr[i] = sc.nextInt();
        }
        System.out.println("The array entered by you is");
        printArray(arr);
        System.out.println("Enter the target to find its frequency in array");
        int target = sc.nextInt();
        countOccurence(arr, target);
        findLastOccurence(arr, target);
        countGreaterElements(arr, target);
        if (checkSorted(arr)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
        sortArrayDescending(arr);
        System.out.println("Array in descending order is");
        printArray(arr);
        System.err.println("Array in increasing order is");
        Arrays.sort(arr);
        printArray(arr);
        System.out.println("Enter the k for kth largest and kth smallest element in array");
        int k = sc.nextInt();
        int[] ans = shortetAndLargestElement(arr, k);
        printArray(ans);
        sc.close();

    }
}
