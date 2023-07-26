import java.util.Arrays;
import java.util.Scanner;

class fibonacci {
    // Recursion Method
    // TC -> O(n)
    // SC -> O(n)

    /*int f(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }*/

    // Dynamic programming Method
    // TC -> O(n)
    // SC -> O(n)+O(n)

    /*int f(int n, int dp[]) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = f(n - 1, dp) + f(n - 2, dp);
    }*/

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ->");
        int n = sc.nextInt();
        /*int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        fibonacci obj = new fibonacci();
        int ans = obj.f(n, dp);*/

        // Tabulation method 
        // TC -> O(n)
        // SC ->O(1)
        int prev2=0;
        int prev=1;
        for(int i=2;i<=n;i++)
        {
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        int ans=prev;
        System.out.println("The fibonacci number is -> " + ans);

    }
}