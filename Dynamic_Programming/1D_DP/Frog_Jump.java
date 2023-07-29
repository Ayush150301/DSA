import java.util.Arrays;
import java.util.Scanner;

public class Frog_Jump {

    // Recursion Some cases time limit exceeded
    public int frogJumpR(int n, int heights[]) {
        return f(n - 1, heights);
    }

    public int f(int i, int[] heights) {
        if (i == 0)
            return 0;

        int left = f(i - 1, heights) + Math.abs(heights[i] - heights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1)
            right = f(i - 2, heights) + Math.abs(heights[i] - heights[i - 2]);
        return Math.min(left, right);
    }

    // Memoization
    public int frogJump(int n, int heights[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n - 1, heights, dp);
    }

    public int f(int i, int[] heights, int[] dp) {
        if (i == 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int left = f(i - 1, heights, dp) + Math.abs(heights[i] - heights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1)
            right = f(i - 2, heights, dp) + Math.abs(heights[i] - heights[i - 2]);
        return dp[i] = Math.min(left, right);
    }

    // Tabulation Method
    public int frogJump2T(int n, int heights[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    // Space optimization
    public int frogJump2SO(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            int curi = Math.min(left, right);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs --> ");
        int n = sc.nextInt();
        int heights[] = new int[n];
        System.out.println("Enter the height of the stairs --> ");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        Frog_Jump obj = new Frog_Jump();
        System.out.print("\nMinimum jumps required to reach top is(Recursion) " + obj.frogJumpR(n, heights));
        System.out.print("\nMinimum jumps required to reach top is(Memoization) " + obj.frogJump(n, heights));
        System.out.print("\nMinimum jumps required to reach top is(Tabulation Method) " + obj.frogJump2T(n, heights));
        System.out.print("\nMinimum jumps required to reach top is(Space optimization) " + obj.frogJump2SO(n, heights));
    }
}
