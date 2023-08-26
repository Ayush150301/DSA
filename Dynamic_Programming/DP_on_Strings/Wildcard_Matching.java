import java.util.Arrays;
import java.util.Scanner;

public class Wildcard_Matching {
    // Recursion
    public boolean isMatch_R(String p, String s) {
        if (f(p.length() - 1, s.length() - 1, p, s) == 1)
            return true;
        else
            return false;
    }

    public int f(int i, int j, String p, String s) {
        // BASE CASE
        if (i < 0 && j < 0)
            return 1;

        if (i < 0 && j >= 0)
            return 0;

        if (j < 0 && i >= 0) {
            for (int ii = 0; i < p.length(); i++) {
                if (p.charAt(ii) != '*')
                    return 0;
            }
            return 1;
        }

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')
            return f(i - 1, j - 1, p, s);
        else {
            if (p.charAt(i) == '*')
                return (f(i - 1, j, p, s) == 1 || f(i, j - 1, p, s) == 1) ? 1 : 0;

            else
                return 0;
        }
    }

    // Memoization
    public boolean isMatch_M(String p, String s) {

        int dp[][] = new int[p.length()][s.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        if (f(p.length() - 1, s.length() - 1, p, s, dp) == 1)
            return true;
        else
            return false;
    }

    private int f(int i, int j, String p, String s, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;

        if (i < 0 && j >= 0)
            return 0;

        if (j < 0 && i >= 0) {
            for (int ii = 0; i < p.length(); i++) {
                if (p.charAt(ii) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')
            return f(i - 1, j - 1, p, s, dp);
        else {
            if (p.charAt(i) == '*')
                return (f(i - 1, j, p, s, dp) == 1 || f(i, j - 1, p, s, dp) == 1) ? 1 : 0;

            else
                return 0;
        }
    }

    // Tabulation
    public boolean isMatch_T(String p, String s) {
        int n = p.length();
        int m = s.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            boolean flag=true;
            for(int ii=1;ii<=i;ii++)
            {
                if(p.charAt(ii-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[i][0]=flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else {
                    if (p.charAt(i - 1) == '*')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

                    else
                        dp[i][j] = false;
                }
            }
        }

        return dp[n][m];

    }

    // Space Optimization
    public boolean isMatch(String p, String s) {
        int n = p.length();
        int m = s.length();

        boolean prev[] = new boolean[m + 1]; //row 0
        boolean cur[] = new boolean[m + 1]; //row 1
        prev[0] = true;

        for (int j = 1; j <= m; j++) {
            prev[j] = false;
        }
        for (int i = 1; i <= n; i++) {
            
        }

        for (int i = 1; i <= n; i++) {
            boolean flag=true;
            for(int ii=1;ii<=i;ii++)
            {
                if(p.charAt(ii-1)!='*'){
                    flag=false;
                    break;
                }
            }
            cur[0]=flag;
            for (int j = 1; j <= m; j++) {

                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
                    cur[j] = prev[j - 1];

                else {
                    if (p.charAt(i - 1) == '*')
                        cur[j] = prev[j] || cur[j - 1];

                    else
                        cur[j] = false;
                }
            }
            prev=cur;
        }

        return prev[m];

    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String P : ");
        String p = sc.next();
        System.out.print("\n");
        System.out.print("Enter the String S : ");
        String s = sc.next();
        System.out.println(
                "Implement wildcard pattern matching(Recursion)--> " + new Wildcard_Matching().isMatch_R(p, s));
        System.out
                .println("Implement wildcard pattern matching(Memoization)--> "
                        + new Wildcard_Matching().isMatch_M(p, s));
        System.out
                .println("Implement wildcard pattern matching(Tabulation)--> "
                        + new Wildcard_Matching().isMatch_T(p, s));
        System.out.println(
                "Implement wildcard pattern matching(Space Optimization)--> " + new Wildcard_Matching().isMatch(p, s));
    }
}
