import java.util.Arrays;
import java.util.Scanner;

public class Matrix_Chain_Multiplication {
    // Recursion
    public static int mcm_R(int[] p) {
        return f(1, p.length - 1, p);

    }

    private static int f(int i, int j, int[] p) {
        if (i == j)
            return 0;
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int steps = p[i - 1] * p[k] * p[j] + f(i, k, p) + f(k + 1, j, p);
            mini = Math.min(mini, steps);
        }
        return mini;
    }

    // Memoization
    public static int mcm_M(int[] p) {
        int dp[][] = new int[p.length][p.length];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, p.length - 1, p, dp);

    }

    private static int f(int i, int j, int[] p, int dp[][]) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int steps = p[i - 1] * p[k] * p[j] + f(i, k, p, dp) + f(k + 1, j, p, dp);
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }

    // Tabulation
    public static int mcm_T(int[] p) {
        int n = p.length;
        int dp[][] = new int[p.length][p.length];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int steps = p[i - 1] * p[k] * p[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][n-1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of matrix :- ");
        int size = sc.nextInt();
        int arr[] = new int[size + 1];
        System.out.println("Enter the elements of the array :- ");
        for (int i = 0; i < size + 1; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The Minimum Number of multiplication needed(Recursion) : " + mcm_R(arr));
        System.out.println("The Minimum Number of multiplication needed(Meomization) : " + mcm_M(arr));
        System.out.println("The Minimum Number of multiplication needed(Tabulation) : " + mcm_T(arr));
    }
}

// input
/*
 * 3
 * 10 15 20 25
 */