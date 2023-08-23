import java.util.Arrays;
import java.util.Scanner;

public class Longest_Palindromic_Subsequence {
    //Recursion
    public int longestPalindromeSubseq_R(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String s2=s1.toString();
        return f(s,s2,s.length()-1,s2.length()-1);
    }
    private int f(String s, String s2, int len1, int len2) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (s.charAt(len1) == s2.charAt(len2))
            return 1 + f(s, s2, len1 - 1, len2 - 1);
        return Math.max(f(s, s2, len1 - 1, len2), f(s, s2, len1, len2 - 1));
    }
    //Memoization
    public int longestPalindromeSubseq_M(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String s2=s1.toString();
        int len1 = s.length();
        int len2 = s2.length();
        int dp[][] = new int[len1][len2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(s, s2, len1 - 1, len2 - 1, dp);
    }
    public int f(String s, String s2, int len1, int len2, int[][] dp) {
        if (len1 < 0 || len2 < 0)
            return 0;

        if (dp[len1][len2] != -1)
            return dp[len1][len2];

        if (s.charAt(len1) == s2.charAt(len2))
            return dp[len1][len2] = 1 + f(s, s2, len1 - 1, len2 - 1, dp);
        return dp[len1][len2] = Math.max(f(s, s2, len1 - 1, len2, dp), f(s, s2, len1, len2 - 1, dp));
    }
    //Tabulation
    public int longestPalindromeSubseq_T(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String s2=s1.toString();
        int len1 = s.length();
        int len2 = s2.length();
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
    //Space Optimization
    public int longestPalindromeSubseq(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String s2=s1.toString();
        int len1 = s.length();
        int len2 = s2.length();
        int prev[] = new int[len2 + 1];

        for (int j = 0; j <= len2; j++)
            prev[j] = 0;
        for (int i = 1; i <= len1; i++) {
            int cur[]=new int[len2+1];
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev=cur;
        }
        return prev[len2];
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string : ");
        String str=sc.next();
        Longest_Palindromic_Subsequence obj=new Longest_Palindromic_Subsequence();
        System.out.println("The Longest Palindrome String (Recursion) : "+obj.longestPalindromeSubseq_R(str));
        System.out.println("The Longest Palindrome String (Memoization) : "+obj.longestPalindromeSubseq_M(str));
        System.out.println("The Longest Palindrome String (Tabulation) : "+obj.longestPalindromeSubseq_T(str));
        System.out.println("The Longest Palindrome String (Space Optimization) : "+obj.longestPalindromeSubseq(str));
    }
}
