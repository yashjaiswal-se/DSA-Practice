import java.util.Scanner;

public class TwoPointerApproach {

    // Method to sort array consisting of only 0s and 1s
    public static void sortZeroesOnes(int[] arr) {
        /*
         * Easier approach:
         * int zeroes=0,ones=0;
         * for(int i=0;i<arr.length;i++){
         * if(arr[i]==0) {
         * zeroes++;
         * } else {
         * ones++;
         * }
         * }
         * for(int i=0;i<zeroes;i++) {
         * arr[i]=0;
         * }
         * for(int j=zeroes+1;j<arr.length;j++){
         * arr[j]=1;
         * }
         */

        // Two pointer approach
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        printArray(arr);
    }

    // Method to sort even and odd such that all even come first
    public static void sortEvenOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 == 0) {
                left++;
            } else if (arr[right] % 2 != 0) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Method to reverse an array
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Method to sort the squared array
    public static void sortSquare(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int[] ans = new int[n];
        int k = n - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k--] = arr[left] * arr[left];
                left++;
            } else {
                ans[k--] = arr[right] * arr[right];
                right--;
            }
        }

        // Optional: copy result back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }

    // print array sum from l to r
    public static void buildPrefixSumArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
    }

    public static void buildSuffixSumArray(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] = arr[i] + arr[i + 1];
        }
    }

    // Method to check if array can be broken into two subarray of equal sum
    public static boolean checkEqualSumArray(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int prefixSum = 0, suffixSum;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            suffixSum = totalSum - prefixSum;
            if (suffixSum == prefixSum) {
                return true;
            }
        }

        return false;
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

        // sortZeroesOnes(arr);
        // sortEvenOdd(arr);
        // sortSquare(arr);

        System.err.println("Enter the value of lower range and higher range");
        int l = sc.nextInt();
        int r = sc.nextInt();

        buildPrefixSumArray(arr);
        printArray(arr);

        r = r - 1;
        if (l == 0) {
            System.out.println("The required sum is " + arr[r]);
        } else {
            System.out.println("The required sum is " + (arr[r] - arr[l - 1]));
        }

        printArray(arr);

        sc.close();
    }
}
