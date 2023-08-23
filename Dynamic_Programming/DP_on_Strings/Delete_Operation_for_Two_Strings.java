import java.util.Arrays;
import java.util.Scanner;

public class Delete_Operation_for_Two_Strings {
    // Recursion
    public int minDistance_R(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence_R(word1, word2);
    }

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
    public int minDistance_M(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence_M(word1, word2);
    }

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
    public int minDistance_T(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence_T(word1, word2);
    }

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
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1, word2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int prev[] = new int[len2 + 1];

        for (int j = 0; j <= len2; j++)
            prev[j] = 0;
        for (int i = 1; i <= len1; i++) {
            int cur[] = new int[len2 + 1];
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev = cur;
        }
        return prev[len2];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String 1 : ");
        String word1 = sc.next();
        System.out.print("Enter the String 2 : ");
        String word2 = sc.next();
        Delete_Operation_for_Two_Strings a = new Delete_Operation_for_Two_Strings();
        System.out.println("The minimum number of steps required(Recursion) : " + a.minDistance_R(word1, word2));
        System.out.println("The minimum number of steps required(Memoization) : " + a.minDistance_M(word1, word2));
        System.out.println("The minimum number of steps required(Tabulation) : " + a.minDistance_T(word1, word2));
        System.out.println("The minimum number of steps required(Space Optimization) : " + a.minDistance(word1, word2));
    }
}
