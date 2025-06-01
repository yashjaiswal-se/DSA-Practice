import java.util.Scanner;

public class TwoDimensionalRectangleProblem {

    // Brute force method
    public static int getSumApproach1(int A[][], int l1, int r1, int l2, int r2) {
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }

    // Method 2: Horizontal prefix sum
    public static void buildHorizontalSumArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j < A[0].length; j++) {
                A[i][j] += A[i][j - 1];
            }
        }
    }

    public static int getSumApproach2(int A[][], int l1, int r1, int l2, int r2) {
        // Important: Make a copy of A to avoid mutation
        int[][] prefix = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, prefix[i], 0, A[0].length);

        buildHorizontalSumArray(prefix);
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            if (r1 >= 1) {
                sum += prefix[i][r2] - prefix[i][r1 - 1];
            } else {
                sum += prefix[i][r2];
            }
        }
        return sum;
    }

    // Method 3: Full 2D prefix sum
    public static void build2DPrefixSum(int[][] A) {
        int R = A.length, C = A[0].length;

        // Row-wise prefix
        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j++) {
                A[i][j] += A[i][j - 1];
            }
        }

        // Column-wise prefix
        for (int j = 0; j < C; j++) {
            for (int i = 1; i < R; i++) {
                A[i][j] += A[i - 1][j];
            }
        }
    }

    public static int getSumApproach3(int A[][], int l1, int r1, int l2, int r2) {
        // Make a copy to avoid mutating original
        int[][] prefix = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, prefix[i], 0, A[0].length);

        build2DPrefixSum(prefix);

        int total = prefix[l2][r2];
        int top = (l1 > 0) ? prefix[l1 - 1][r2] : 0;
        int left = (r1 > 0) ? prefix[l2][r1 - 1] : 0;
        int topLeft = (l1 > 0 && r1 > 0) ? prefix[l1 - 1][r1 - 1] : 0;

        return total - top - left + topLeft;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] A = new int[R][C];

        // Read the matrix
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int Q = sc.nextInt(); // Number of queries
        for (int q = 0; q < Q; q++) {
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();

            int sum = getSumApproach3(A, l1, r1, l2, r2); // 2D prefix

            System.out.println("Sum: " + sum);
        }
        sc.close();
    }
}
