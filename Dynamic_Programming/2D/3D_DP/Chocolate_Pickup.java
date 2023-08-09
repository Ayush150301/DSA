import java.util.Arrays;
import java.util.Scanner;

public class Chocolate_Pickup {
    // Recursion
    public static int maximumChocolates_R(int r, int c, int[][] grid) {
        int i = 0;
        int j1 = 0;
        int j2 = grid[0].length;
        return f(i, j1, j2 - 1, grid);
    }

    private static int f(int i, int j1, int j2, int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return Integer.MIN_VALUE;
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int val = 0;
                if (j1 == j2)
                    val = grid[i][j1];
                else
                    val = grid[i][j1] + grid[i][j2];
                val += f(i + 1, j1 + d1, j2 + d2, grid);
                maxi = Math.max(maxi, val);
            }

        }
        return maxi;
    }

    // Memoization
    public static int maximumChocolates_M(int r, int c, int[][] grid) {
        int dp[][][] = new int[r][c][c];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return f(0, 0, c - 1, grid, dp);
    }

    private static int f(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int m = grid[0].length;
        int n = grid.length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return Integer.MIN_VALUE;
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int val = 0;
                if (j1 == j2)
                    val = grid[i][j1];
                else
                    val = grid[i][j1] + grid[i][j2];
                val += f(i + 1, j1 + d1, j2 + d2, grid);
                maxi = Math.max(maxi, val);
            }

        }
        return dp[i][j1][j2] = maxi;
    }

    // Tabulation
    public static int maximumChocolates_T(int n, int m, int[][] grid) {
        int dp[][][] = new int[n][m][m];

    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          dp[n - 1][j1][j2] = grid[n - 1][j1];
        else
          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    //Outer Nested Loops for travering DP Array
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {

          int maxi = Integer.MIN_VALUE;

          //Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              if ((j1 + di < 0 || j1 + di >= m) ||
                (j2 + dj < 0 || j2 + dj >= m))

                ans += (int) Math.pow(-10, 9);
              else
                ans += dp[i + 1][j1 + di][j2 + dj];

              maxi = Math.max(ans, maxi);
            }
          }
          dp[i][j1][j2] = maxi;
        }
      }
    }

    return dp[0][0][m - 1];
    }

    // Space Optimization
    public static int maximumChocolates(int n, int m, int[][] grid) {
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }

            for (int a = 0; a < m; a++) {
                front[a] = (int[]) (cur[a].clone());
            }
        }

        return front[0][m - 1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the columns: ");
        int col = sc.nextInt();
        int grid[][] = new int[row][col];
        System.out.println("Enter the elements of the grid: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("The Maximum number of chcoloates(Recursion) : " + maximumChocolates_R(row, col, grid));
        System.out.println("The Maximum number of chcoloates(Memoization) : " + maximumChocolates_M(row, col, grid));
        System.out.println("The Maximum number of chcoloates(Tabulation) : " + maximumChocolates_T(row, col, grid));
        System.out.println("The Maximum number of chcoloates(Space Optimization) : " + maximumChocolates(row, col, grid));
    }
}
