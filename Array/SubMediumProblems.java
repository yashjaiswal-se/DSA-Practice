import java.util.Scanner;

public class SubMediumProblems {

    // Helper function to swap values
    public static void swap(int arr[], int a, int b) {
        if (a == b)
            return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Reverse a array using another array
    public static void reverseArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[(arr.length - 1) - i];
        }
        printArray(ans);
    }

    // Reverse a array without using any new array
    public static void reverseArrayInPlace(int[] arr) {
        for (int i = 0; i < (arr.length / 2); i++) {
            swap(arr, i, (arr.length - 1) - i);
        }
        printArray(arr);
    }

    // Rotate a array by k places with a new array
    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] ans = new int[n];

        // Copy last k elements to front
        for (int i = 0; i < k; i++) {
            ans[i] = arr[n - k + i];
        }

        // Copy first n-k elements after that
        for (int i = k; i < n; i++) {
            ans[i] = arr[i - k];
        }

        printArray(ans);
    }

    public static void reverseHelper(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // Rotate a array by k places(in -place)
    public static void rotateArrayInPlace(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        if (k != 0) {
            reverseHelper(arr, 0, n - 1);
            reverseHelper(arr, 0, k - 1);
            reverseHelper(arr, k, n - 1);
        }
        printArray(arr);
    }

    // Method to build frequency array
    public static void buildFrequencyArray(int[] arr, int[] frequency) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] < frequency.length) {
                frequency[arr[i]] += 1;
            } else {
                System.out.println("Warning: Value " + arr[i] + " out of frequency array bounds.");
            }
        }
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
        // everseArray(arr);
        // reverseArrayInPlace(arr);

        System.out.println("Enter the value of k for rotation");
        // int k = sc.nextInt();
        // rotateArray(arr, k);
        // rotateArrayInPlace(arr, k);

        // Given question is like we need to return frequency of element in array
        int[] frequency = new int[1000]; // we assume value range from 0 to 1000
        buildFrequencyArray(arr, frequency);
        int q = 0;
        while (q == 0) {
            System.out.print("Enter 0 to query or 1 to avoid");
            q = sc.nextInt();
            switch (q) {
                case 0:
                    System.out.println("Enter the element to look for its frequency:");
                    int num = sc.nextInt();
                    if (num >= 0 && num < frequency.length) {
                        System.out.println("Frequency of " + num + ": " + frequency[num]);
                    } else {
                        System.out.println("Value out of supported range (0-999).");
                    }
                    break;

                case 1:
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Wrong choice! Exiting.");
            }
        }
        sc.close();
    }
}
