import java.util.Arrays;
import java.util.Scanner;

public class Unique_Paths {
    // Recursion
    public int uniquePaths_R(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        int l = uniquePaths_R(m - 1, n);
        int r = uniquePaths_R(m, n - 1);
        return l + r;
    }

    // Memoization
    public int f(int m, int n, int dp[][]) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1)
            return dp[m][n];
        int up = f(m - 1, n, dp);
        int left = f(m, n - 1, dp);
        return dp[m][n] = up + left;
    }

    public int uniquePaths_M(int m, int n) {
        int dp[][] = new int[m][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(m - 1, n - 1, dp);
    }

    // Tabulation
    public int uniquePaths_T(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i == 0 & j == 0)
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
        return dp[m - 1][n - 1];
    }

    // Space Optimization
    public int uniquePaths(int m, int n) {
        int prev[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0&j==0)temp[j]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=prev[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = sc.nextInt();
        Unique_Paths obj = new Unique_Paths();
        System.out.println("The possible number of ways(Recusrion) --> " + obj.uniquePaths_R(m - 1, n - 1));
        System.out.println("The possible number of ways(Memoization) --> " + obj.uniquePaths_M(m, n));
        System.out.println("The possible number of ways(Tabulation) --> "+obj.uniquePaths_T(m, n));
        System.out.println("The possible number of ways(Space Optimization) --> "+obj.uniquePaths(m, n));
    }
}
