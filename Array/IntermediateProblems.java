import java.util.Scanner;

public class IntermediateProblems {

    /*
     * Pattern: Target Sum
     */

    // Method to count number of pairs whose sum is equal to target
    public static int pairSum(int[] arr, int target) {
        int countPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    countPairs = countPairs + 1;
                }
            }
        }
        return countPairs;
    }

    // Method to count number of triplets whose sum is equal to target
    public static int tripletSum(int[] arr, int target) {
        int countTriplets = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        countTriplets = countTriplets + 1;
                    }
                }
            }
        }
        return countTriplets;
    }

    /*
     * Pattern:Array Manipulation
     */

    // find the unique element in a given array where all elements are repeated
    // twice except the one value being unique
    public static int findUniqueElement(int[] arr) {
        int unique = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = -1;
                    arr[i] = -1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                unique = arr[i];
            }
        }
        return unique;
    }

    // Method to print second largest element
    public static int secondLargestElement(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int num : arr) {
            if (num > max) {
                second = max;
                max = num;
                foundSecond = true;
            } else if (num < max && num > second) {
                second = num;
                foundSecond = true;
            }
        }

        if (!foundSecond) {
            throw new IllegalArgumentException(
                    "No second largest element found (array may contain all identical elements).");
        }

        return second;
    }

    // Method to print the first repeating element in the array.
    public static int findFirstRepeatingElement(int[] arr) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    ans = arr[i];
                    return ans;

                }
            }
        }
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
        /*
         * System.out.println("Enter the target");
         * int target = sc.nextInt();
         * int ans = pairSum(arr, target);
         * System.out.println("The number of pairs whose sum are equal to target is " +
         * ans);
         * ans = tripletSum(arr, target);
         * System.out.println("The number of triplets whose sum are equal to target is "
         * + ans);
         */
        // int res = findUniqueElement(arr);
        /*
         * if (res != -1) {
         * System.out.println("The unique element in our array is " + res);
         * } else {
         * System.out.println("There are no unique elements in the array");
         * }
         */
        int res = secondLargestElement(arr);
        System.out.println("Second largest element in array is " + res);
        System.out.println("The first repeating element in array is " + findFirstRepeatingElement(arr));
        sc.close();
    }
}
