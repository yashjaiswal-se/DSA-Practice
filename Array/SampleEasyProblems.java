import java.util.*;

public class SampleEasyProblems {

    // Method to print sum of Array
    public static void sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("The sum of array is " + sum);
    }

    // Method to print maximum element in array
    public static void printMaximumElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Maximum Element in array is " + max);
    }

    // Method to perform linear search
    public static boolean performLinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // Method to alter array -say square of each element
    public static void squareArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        printArray(arr);
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

        /*
         * sumArray(arr);
         * printMaximumElement(arr);
         * System.out.println("Enter the element to search");
         * int target = sc.nextInt();
         * boolean res = performLinearSearch(arr, target);
         * if (res) {
         * System.out.println("Item found successfully");
         * } else {
         * System.out.println("Item could not be found");
         * }
         */
        // Array References
        int[] arr_copy = arr;

        /*
         * squareArray(arr_copy);
         * System.out.println("Printing copied array after squaring each element: ");
         * printArray(arr_copy);
         * System.out.println("Printing original array after squaring each element: ");
         * printArray(arr);
         */

        // Copying array by this array is not quite accurate because it directly copies
        // the address of the original array to copied array because of which, any
        // change in copied array is reflected back to original array as well.

        arr_copy = arr.clone();
        squareArray(arr_copy);
        System.out.println("Printing copied array after squaring each element: ");
        printArray(arr_copy);
        System.out.println("Printing original array after squaring each element: ");
        printArray(arr);

        // another method-
        arr_copy = Arrays.copyOf(arr, arr.length);
        squareArray(arr_copy);
        System.out.println("Printing copied array after squaring each element: ");
        printArray(arr_copy);
        System.out.println("Printing original array after squaring each element: ");
        printArray(arr);
        sc.close();

    }
}