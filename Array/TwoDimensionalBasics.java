import java.util.Scanner;

public class TwoDimensionalBasics {

    // Method to create a two-dimensional array
    public static int[][] createArray(int r, int c, Scanner sc) {

        int[][] arr = new int[r][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter element at " + i + "th row and " + j + "th column: ");
                arr[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        return arr;

    }

    // Method to print 2-dimensional array
    public static void displayArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to add two array
    public static void addArray(int[][] A, int[][] B) {
        if (A.length == B.length && A[0].length == B[0].length) {
            int[][] sum = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    sum[i][j] = A[i][j] + B[i][j];
                }
            }
            displayArray(sum);
        } else {
            System.out.println("Mismatched Array order");
        }
    }

    // Method to multiply two matrices
    public static void multiplyArray(int[][] A, int[][] B) {
        if (A[0].length == B.length) {
            int[][] prod = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        prod[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            displayArray(prod);
        } else {
            System.out.println("Mismatched Array order for multiplication.");
        }
    }

    // Method to perform transpose of a matrix using a new matrix
    public static void performTranspose(int[][] A, int r, int c) {
        System.out.println("Transpose of matrix is:");
        int[][] transpose = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transpose[j][i] = A[i][j];
            }
        }

        displayArray(transpose);
    }

    // Method to perform transpose of a matrixinplace
    public static void performTransposeInPlace(int[][] A, int r, int c) {
        System.out.println("Transpose of matrix is:");

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        displayArray(A);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows for Array A");
        int r = sc.nextInt();
        System.out.println("Enter the number of columns for Array A");
        int c = sc.nextInt();

        System.out.println("Array A");
        int A[][] = createArray(r, c, sc);
        displayArray(A);

        /*
         * System.out.println("Enter the number of rows for Array B");
         * r = sc.nextInt();
         * System.out.println("Enter the number of columns for Array B");
         * c = sc.nextInt();
         * 
         * System.out.println("Array B");
         * int B[][] = createArray(r, c, sc);
         * 
         * System.out.println("Array A");
         * displayArray(A);
         * 
         * System.out.println("Array B");
         * displayArray(B);
         * 
         * System.out.println("Adding Array A and Array B: ");
         * addArray(A, B);
         * System.out.println("Multiplying Array A and Array B: ");
         * multiplyArray(A, B);
         */

        performTranspose(A, r, c);
        performTransposeInPlace(A, r, c);

        sc.close();
    }
}
