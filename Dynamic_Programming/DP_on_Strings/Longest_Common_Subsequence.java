import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_Subsequence {
    // Recursion
    public int longestCommonSubsequence_R(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        return f(text1, text2, len1 - 1, len2 - 1);
    }

    private int f(String text1, String text2, int len1, int len2) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (text1.charAt(len1) == text2.charAt(len2))
            return 1 + f(text1, text2, len1 - 1, len2 - 1);
        return Math.max(f(text1, text2, len1 - 1, len2), f(text1, text2, len1, len2 - 1));
    }

    // Memoization
    public int longestCommonSubsequence_M(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int dp[][] = new int[len1][len2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(text1, text2, len1 - 1, len2 - 1, dp);
    }

    public int f(String text1, String text2, int len1, int len2, int[][] dp) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (dp[len1][len2] != -1)
            return dp[len1][len2];

        if (text1.charAt(len1) == text2.charAt(len2))
            return dp[len1][len2] = 1 + f(text1, text2, len1 - 1, len2 - 1, dp);
        return dp[len1][len2] = Math.max(f(text1, text2, len1 - 1, len2, dp), f(text1, text2, len1, len2 - 1, dp));
    }

    // Tabulation
    public int longestCommonSubsequence_T(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }

    // Space Optimization
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int prev[] = new int[len2 + 1];

        for (int j = 0; j <= len2; j++)
            prev[j] = 0;
        for (int i = 1; i <= len1; i++) {
            int cur[]=new int[len2+1];
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev=cur;
        }
        return prev[len2];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String 1 : ");
        String text1 = sc.next();
        System.out.print("Enter the String 2 : ");
        String text2 = sc.next();
        Longest_Common_Subsequence lcs = new Longest_Common_Subsequence();
        System.out.println("Longest Common Subsequence of two strings is (Recusrion): "
                + lcs.longestCommonSubsequence_R(text1, text2));
        System.out.println("Longest Common Subsequence of two strings is (Memoization): "
                + lcs.longestCommonSubsequence_M(text1, text2));
        System.out.println("Longest Common Subsequence of two strings is (Tabulation): "
                + lcs.longestCommonSubsequence_T(text1, text2));
        System.out.println("Longest Common Subsequence of two strings is (Space Optimization): "
                + lcs.longestCommonSubsequence(text1, text2));
    }
}
