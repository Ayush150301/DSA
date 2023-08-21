import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_Substring {
    // Recursion
    public static int lcs_R(String str1, String str2) {
        return f(str1.length(), str2.length(), 0, str1, str2);
    }

    private static int f(int i, int j, int count, String str1, String str2) {
        if (i == 0 || j == 0)
            return count;

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            count = f(i - 1, j - 1, count + 1, str1, str2);
        }
        int count1 = f(i, j - 1, 0, str1, str2);
        int count2 = f(i - 1, j, 0, str1, str2);
        count = Math.max(count, Math.max(count1, count2));
        return count;
    }

    // Memoization
    public static int lcs_M(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(str1.length(), str2.length(), 0, str1, str2, dp);
    }

    private static int f(int i, int j, int count, String str1, String str2, int[][] dp) {
        if (i == 0 || j == 0)
            return count;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (str1.charAt(i - 1) == str2.charAt(j - 1))
            count = f(i - 1, j - 1, count + 1, str1, str2, dp);

        int count1 = f(i, j - 1, 0, str1, str2, dp);
        int count2 = f(i - 1, j, 0, str1, str2, dp);

        count = Math.max(count, Math.max(count1, count2));
        dp[i][j] = count;
        return count;
    }

    // Tabulation
    public static int lcs_T(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int ans = 0;
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int val = dp[i - 1][j - 1] + 1;
                    dp[i][j] = val;
                    ans = Math.max(val, ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    // Space Optimization
    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int val = 1 + prev[j - 1];
                    cur[j] = val;
                    ans = Math.max(ans, val);
                } else
                    cur[j] = 0;
            }
            prev = cur;
        }
        return ans;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String 1 : ");
        String str1 = sc.next();
        System.out.print("Enter the String 2 : ");
        String str2 = sc.next();
        System.out.println("The length of the Longest Common Substring (Recursion) : " + lcs_R(str1, str2));
        System.out.println("The length of the Longest Common Substring (Memoization) : " + lcs_M(str1, str2));
        System.out.println("The length of the Longest Common Substring (Tabulation) : " + lcs_T(str1, str2));
        System.out.println("The length of the Longest Common Substring (Space Optimization) : " + lcs(str1, str2));
    }
}
