import java.util.Arrays;
import java.util.Scanner;

public class Distinct_Subsequences {
    // Recursion
    public int numDistinct_R(String s, String t) {
        return f(s.length() - 1, t.length() - 1, s, t);
    }

    public int f(int i, int j, String s, String t) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return f(i - 1, j - 1, s, t) + f(i - 1, j, s, t);
        } else {
            return f(i - 1, j, s, t);
        }
    }

    // Memoization
    public int numDistinct_M(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, s, t, dp);
    }

    public int f(int i, int j, String s, String t, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return dp[i][j] = f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp);
        else
            return dp[i][j] = f(i - 1, j, s, t, dp);

    }

    // Tabulation
    public int numDistinct_T(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    // Space Optimization
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    prev[j] = prev[j - 1] + prev[j];
            }

        }
        return prev[m];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string 1 : ");
        String s = sc.next();
        System.out.print("Enter the string 2 : ");
        String t = sc.next();
        Distinct_Subsequences obj = new Distinct_Subsequences();
        System.out.println("The Number of Distinct Subsequence are(Recursion) : " + obj.numDistinct_R(s, t));
        System.out.println("The Number of Distinct Subsequence are(Memoization) : " + obj.numDistinct_M(s, t));
        System.out.println("The Number of Distinct Subsequence are(Tabulation) : " + obj.numDistinct_T(s, t));
        System.out.println("The Number of Distinct Subsequence are(Space Optimization) : " + obj.numDistinct(s, t));

    }
}
