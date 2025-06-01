import java.util.ArrayList;
import java.util.List;

public class StriverEasyProblems {
    // Problem-1: Print the greatest element from array
    public static void printGreatestElement(int[] arr) {
        // Brute Force-sort the array using any technique and print arr[n-1] - O(n log
        // n) time complexity
        // optimal soln
        // we assume array is not null i.e. has atleast one element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Largest Element in array is " + max);

    }

    // Problem-2: print the second largest element in array
    public static void printSecondLargestElement(int[] arr) {
        // Brute force- sort and print arr[n-2]
        // fails for array like {1,2,4,5,1,7,7}
        /*
         * Another way is to implement this to prevent above
         * we assume array is sorted
         * int largest=arr[n-1],n;
         * n=arr.length;
         * for(int i=n-1;i>=0;i--){
         * if(arr[i]!=largest)
         * {
         * System.out.println(arr[i]);
         * break;
         * }
         * }
         * 
         * Time complexity- O(n log n)+O(n)
         */

        /*
         * Better approach
         * int max = arr[0];
         * for (int i = 1; i < arr.length; i++) {
         * if (arr[i] > max) {
         * max = arr[i];
         * }
         * }
         * int secondMax=arr[0];
         * for (int i = 1; i < arr.length; i++) {
         * if (arr[i] > secondMax && arr[i]!=largest) {
         * secondMax = arr[i];
         * }
         * }
         * System.out.println(secondMax)
         * 
         * Time complexity- O(n+n)
         * 
         */
        // optimal
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
                foundSecond = true;
            } else if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
                foundSecond = true;
            }
        }

        if (foundSecond) {
            System.out.println("Second largest element in array is " + secondMax);
        } else {
            System.out.println("No second largest element found (all elements might be equal).");
        }
    }

    // Problem-3: Check if array is sorted and rotated
    public static boolean isCircularlySorted(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; //
            if (arr[i] > arr[next]) {
                count++;
            }
        }

        return count <= 1;
    }

    // Problem-4: Remove duplicate in-place from sorted array
    public static int removeDuplicates(int[] arr) {

        // brute- use set data structure to store unique elements and iterate over array
        // to set all unique element at begining of array
        // optimal
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1; // returning length of sorted array
    }

    // Problem-5: Rotate array by one place;
    public static void rotateArrayByOnePlace(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    // Problem-6: Left rotate array by k places

    public static void reversehelper(int[] arr, int st, int end) {
        while (st < end) {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }

    public static void rotateArrayByKPlaces(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n
        reversehelper(arr, 0, n - k - 1);
        reversehelper(arr, n - k, n - 1);
        reversehelper(arr, 0, n - 1);
    }

    // Problem-7: move all zeros to the end
    public static void moveAllZeroToEnd(int[] arr) {
        // Brute- move all non-zero element to list and then frokm the list back to
        // front of array and the rest index shall have zero
        int j = -1;

        // Step 1: Find the first zero
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // Step 2: Swap non-zero elements after first zero
        if (j != -1) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] != 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j++;
                }
            }
        }
    }

    // Problem-8: Linear Search
    public static boolean checkElementOccurence(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // Problem-9: Union and intersection of array
    public static void performUnion(int[] A, int[] B) {
        // Brute

        // create a set data structure and first moveall unique element from first array
        // to set and then element from second array to set

        // Optimal
        int n1 = A.length;
        int n2 = B.length;
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            // Skip duplicates in A
            if (i > 0 && A[i] == A[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in B
            if (j > 0 && B[j] == B[j - 1]) {
                j++;
                continue;
            }

            if (A[i] < B[j]) {
                result.add(A[i]);
                i++;
            } else if (A[i] > B[j]) {
                result.add(B[j]);
                j++;
            } else {
                result.add(A[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from A
        while (i < n1) {
            if (i == 0 || A[i] != A[i - 1]) {
                result.add(A[i]);
            }
            i++;
        }

        // Add remaining elements from B
        while (j < n2) {
            if (j == 0 || B[j] != B[j - 1]) {
                result.add(B[j]);
            }
            j++;
        }

        // Print result
        System.out.println("Union: " + result);
    }

    public static void performIntersection(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            // Skip duplicates in A
            if (i > 0 && A[i] == A[i - 1]) {
                i++;
                continue;
            }
            // Skip duplicates in B
            if (j > 0 && B[j] == B[j - 1]) {
                j++;
                continue;
            }

            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                result.add(A[i]);
                i++;
                j++;
            }
        }

        System.out.println("Intersection: " + result);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 3, 4, 4, 5 };
        int[] arr2 = { 2, 4, 6, 6, 7 };

        // Problem-1
        printGreatestElement(arr1);

        // Problem-2
        printSecondLargestElement(arr1);

        // Problem-3
        int[] rotatedSorted = { 3, 4, 5, 1, 2 };
        System.out.println("Is Circularly Sorted: " + isCircularlySorted(rotatedSorted));

        // Problem-4
        int[] duplicatesArr = { 1, 1, 2, 2, 3, 4, 4 };
        int newLength = removeDuplicates(duplicatesArr);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(duplicatesArr[i] + " ");
        }
        System.out.println();

        // Problem-5
        int[] rotateOne = { 1, 2, 3, 4, 5 };
        rotateArrayByOnePlace(rotateOne);
        System.out.print("Rotated by one: ");
        for (int num : rotateOne) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Problem-6
        int[] rotateK = { 1, 2, 3, 4, 5 };
        rotateArrayByKPlaces(rotateK, 2);
        System.out.print("Rotated by 2: ");
        for (int num : rotateK) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Problem-7
        int[] zerosArray = { 0, 1, 0, 3, 12 };
        moveAllZeroToEnd(zerosArray);
        System.out.print("Zeros moved to end: ");
        for (int num : zerosArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Problem-8
        int target = 3;
        System.out.println("Is " + target + " present: " + checkElementOccurence(arr1, target));

        // Problem-9 - Union
        performUnion(arr1, arr2);

        // Problem-9 - Intersection
        performIntersection(arr1, arr2);
    }

}
