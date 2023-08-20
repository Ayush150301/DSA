import java.util.Scanner;
import java.util.Arrays;

public class Print_Longest_Common_Subsequence {

    // Recursion
    public static String findLCS_R(int len1, int len2, String s1, String s2) {

        return f(0, 0, len1, len2, s1, s2);
    }

    private static String f(int i, int j, int len1, int len2, String s1, String s2) {
        if (i == len1 || j == len2)
            return "";

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + f(i + 1, j + 1, len1, len2, s1, s2);
        }
        return max(f(i + 1, j, len1, len2, s1, s2), f(i, j + 1, len1, len2, s1, s2));
    }

    private static String max(String f1, String f2) {
        if (f1.length() > f2.length())
            return f1;
        else
            return f2;
    }

    // Memoization
    public static String findLCS_M(int n, int m, String s1, String s2) {
        String dp[][]=new String[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = "";
            }
        }
        return f(0, 0, n, m, s1, s2,dp);
    }

    private static String f(int i, int j, int len1, int len2, String s1, String s2, String[][] dp) {
        if (i == len1 || j == len2)
            return "";

        if(dp[i][j]!="")
        return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return s1.charAt(i) + f(i + 1, j + 1, len1, len2, s1, s2,dp);
        }
        return dp[i][j]=max(f(i + 1, j, len1, len2, s1, s2,dp), f(i, j + 1, len1, len2, s1, s2,dp));
    }

    // Tabulation
    public static String findLCS_T(int n, int m, String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // Converting the longest common subsequence
        int i = s1.length();
        int j = s2.length();
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the String 1 : ");
        String s1 = sc.next();
        // System.out.print("Enter the String 2 : ");
        String s2 = sc.next();
        int len1 = s1.length();
        int len2 = s2.length();
        System.out.println("The Longest Commom Subsequence (Recursion) : " + findLCS_R(len1, len2, s1, s2));
        System.out.println("The Longest Commom Subsequence (Memoization) : " + findLCS_M(len1, len2, s1, s2));
        System.out.println("The Longest Commom Subsequence (Tabulation) : " + findLCS_T(len1, len2, s1, s2));
        System.out.println("The Longest Commom Subsequence (Space Optimization) : Not possible as we need the whole array to backtrack");
    }
}
