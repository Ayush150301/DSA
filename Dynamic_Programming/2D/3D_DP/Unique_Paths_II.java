import java.util.Arrays;
import java.util.Scanner;

public class Unique_Paths_II {
    // Recursion
    public int uniquePathsWithObstacles_R(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        return f(n - 1, m - 1, obstacleGrid);
    }

    private int f(int n, int m, int[][] obstacleGrid) {
        if (n == 0 && m == 0)
            return 1;
        if (n >= 0 && m >= 0 && obstacleGrid[n][m] == 1)
            return 0;
        if (n < 0 || m < 0)
            return 0;
        int up = f(n - 1, m, obstacleGrid);
        int left = f(n, m - 1, obstacleGrid);
        return up + left;
    }

    // Memoization
    private int f_M(int n, int m, int[][] obstacleGrid, int dp[][]) {
        if (n == 0 && m == 0)
            return 1;
        if (n >= 0 && m >= 0 && obstacleGrid[n][m] == 1)
            return 0;
        if (n < 0 || m < 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        int up = f_M(n - 1, m, obstacleGrid, dp);
        int left = f_M(n, m - 1, obstacleGrid, dp);
        return dp[n][m] = up + left;
    }

    public int uniquePathsWithObstacles_M(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f_M(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid, dp);
    }

    // Tabulation
    public int uniquePathsWithObstacles_T(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    // Space Optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int prev[] = new int[n];
        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0 && obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = up + left;
            }
            prev = temp;
        }

        return prev[n - 1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Row: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of Column:");
        int m = sc.nextInt();
        int obstacleGrid[][] = new int[n][m];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }
        Unique_Paths_II obj = new Unique_Paths_II();
        System.out.println(
                "The number of possible unique paths(Recursion): " + obj.uniquePathsWithObstacles_R(obstacleGrid));
        System.out.println(
                "The number of possible unique paths(Memoization): " + obj.uniquePathsWithObstacles_M(obstacleGrid));
        System.out.println(
                "The number of possible unique paths(Tabulation): " + obj.uniquePathsWithObstacles_T(obstacleGrid));
        System.out.println("The number of possible unique paths(Space Optimization): "
                + obj.uniquePathsWithObstacles(obstacleGrid));
    }

}
