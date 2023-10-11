import java.util.Arrays;
import java.util.Scanner;

public class Palindrome_Partitioning_II {

    public static void isPalindrome(String s,int[][] isPalindrome){
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i] = 0;
            for(int j=i-1,k=i+1;j>=0&&k<s.length();j--,k++){
                if(s.charAt(j)==s.charAt(k)) isPalindrome[j][k] = 0;
                else break;
            }
            for(int j=i,k=i+1;j>=0&&k<s.length();j--,k++){
                if(s.charAt(j)==s.charAt(k)) isPalindrome[j][k] = 0;
                else break;
            }
        }
    }
    // Recursion
    public int minCut_R(String s) {
        int n = s.length();
        return f(0, n, s) - 1;
    }

    private int f(int i, int n, String s) {
        if (i == n)
            return 0;
        int mini = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i,j,s)) {
                int cost = 1 + f(j + 1, n, s);
                mini = Math.min(mini, cost);
            }
        }
        return mini;
    }

    
    private boolean isPalindrome(int i, int j, String s) {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    // Memoization
    public int minCut_M(String s) {
        int n = s.length();
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(0, n, s, dp) - 1;
    }

    private int f(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int mini = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i,j,s)) {
                int cost = 1 + f(j + 1, n, s, dp);
                mini = Math.min(mini, cost);
            }
        }
        return dp[i] = mini;
    }

    // Tabulation
    public int minCut_T(String s) {
        int[][] isPalindrome = new int[s.length()][s.length()];
        Arrays.stream(isPalindrome).forEach(a -> Arrays.fill(a,-1));
        isPalindrome(s,isPalindrome);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]==0) {
                    int cost = 1 + dp[j + 1];
                    mini = Math.min(mini, cost);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        Palindrome_Partitioning_II obj = new Palindrome_Partitioning_II();
        System.out.println("\nMin Cut using Recursion: " + obj.minCut_R(str));
        System.out.println("\nMin Cut using memoization: " + obj.minCut_M(str));
        System.out.println("\nMin Cut using tabulation: " + obj.minCut_T(str));
    }
}

// aab --> 1
// a --> 0
// aaccb --> 2