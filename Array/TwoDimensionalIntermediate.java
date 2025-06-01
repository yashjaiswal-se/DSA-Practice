import java.util.Scanner;

public class TwoDimensionalIntermediate {
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
    }

    // Method to rotate a square matrix by 90 degree without using any extra space
    public static void rotateArray(int[][] A, int r, int c) {
        performTransposeInPlace(A, r, c);

        int left = 0, right = c - 1, temp;
        while (left < right) {
            for (int i = 0; i < r; i++) {
                temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
            }
            left++;
            right--;
        }
        displayArray(A);
    }

    // Method to generate Pascal triangle
    public static void generatePascalTriangle(int n) {
        int ans[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            ans[i] = new int[i + 1];
            ans[i][0] = ans[i][i] = 1;
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
        }
        displayArray(ans);
    }

    // Method for spiral order traversal
    public static void printSpiralOrderMatrix(int[][] A, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElement = 0;

        while (totalElement < r * c) {
            // Top row (left to right)
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                System.out.print(A[topRow][j] + " ");
                totalElement++;
            }
            topRow++;

            // Right column (top to bottom)
            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                System.out.print(A[i][rightCol] + " ");
                totalElement++;
            }
            rightCol--;

            // Bottom row (right to left)
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                System.out.print(A[bottomRow][j] + " ");
                totalElement++;
            }
            bottomRow--;

            // Left column (bottom to top)
            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                System.out.print(A[i][leftCol] + " ");
                totalElement++;
            }
            leftCol++;
        }
    }

    public static void generateAntiClockwiseSpiralMatrix(int[][] A, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElement = 0;

        while (totalElement < r * c) {

            // Left column (top to bottom)
            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                A[i][leftCol] = ++totalElement;
            }
            leftCol++;
            // Bottom row (left to right)
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                A[bottomRow][j] = ++totalElement;
            }
            bottomRow--;
            // Right column (bottom to top)
            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                A[i][rightCol] = ++totalElement;
            }
            rightCol--;
            // Top row (right to left)
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                A[topRow][j] = ++totalElement;
            }
            topRow++;

        }
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

        // rotateArray(A, r, c);

        /*
         * System.out.println("Enter the number of rows for pascal triangle");
         * int n = sc.nextInt();
         * generatePascalTriangle(n);
         */

        // printSpiralOrderMatrix(A, r, c);
        generateAntiClockwiseSpiralMatrix(A, r, c);
        displayArray(A);
    }

}
