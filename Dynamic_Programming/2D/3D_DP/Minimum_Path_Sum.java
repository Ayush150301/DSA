import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Path_Sum {
    // Recursion
    public int minPathSum_R(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return f(n - 1, m - 1, grid);
    }

    private int f(int n, int m, int[][] grid) {
        if (n == 0 && m == 0) {
            return grid[0][0];
        }
        if (n < 0 || m < 0)
            return 999;
        int up = grid[n][m] + f(n - 1, m, grid);
        int left = grid[n][m] + f(n, m - 1, grid);
        return Math.min(up, left);
    }

    // Memoization
    public int minPathSum_M(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(n-1, m-1, grid, dp);
    }

    private int f(int n, int m, int[][] grid, int[][] dp) {
        if (n == 0 && m == 0) {
            return grid[0][0];
        }
        if (n < 0 || m < 0)
            return 999;
        if (dp[n][m] != -1)
            return dp[n][m];
        int up = grid[n][m] + f(n - 1, m, grid,dp);
        int left = grid[n][m] + f(n, m - 1, grid,dp);
        return dp[n][m] = Math.min(up, left);
    }

    // Tabulation
    public int minPathSum_T(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0&&j==0) dp[i][j]=grid[i][j];
                else{
                    int up=grid[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up+=(int)Math.pow(10,9);

                    int left=grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left+=(int)Math.pow(10, 9);

                    dp[i][j]=Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
    }

    // Space Optimization
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prev[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int temp[]=new int[m];
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                {
                    temp[j]=grid[i][j];
                }
                else{
                    int up=grid[i][j];
                    if(i>0) up+=prev[j];
                    else up+=(int)Math.pow(10,9);

                    int left=grid[i][j];
                    if(j>0) left+=temp[j-1];
                    else left+=(int)Math.pow(10, 9);

                    temp[j]=Math.min(up, left);
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Row: ");
        int n = sc.nextInt();
        System.out.print("Enter the Number Of Column: ");
        int m = sc.nextInt();
        int grid[][] = new int[n][m];
        System.out.println("Enter the elements of the grid: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        Minimum_Path_Sum obj = new Minimum_Path_Sum();
        System.out.println("Minimum Path Sum is(Recusrion): " + obj.minPathSum_R(grid));
        System.out.println("Minimum Path Sum is(Memoization): " + obj.minPathSum_M(grid));
        System.out.println("Minimum Path Sum is(Tabulation): " + obj.minPathSum_T(grid));
        System.out.println("Minimum Path Sum is(Space Optimization): " + obj.minPathSum(grid));

    }
}
