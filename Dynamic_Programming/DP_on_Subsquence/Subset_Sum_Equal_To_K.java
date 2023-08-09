import java.util.Arrays;
import java.util.Scanner;

public class Subset_Sum_Equal_To_K {
    // Recursion
    public static boolean subsetSumToK_R(int n, int target, int[] arr) {

        return f(n - 1, target, arr);
    }

    private static boolean f(int ind, int target, int[] arr) {
        if (target == 0)
            return true;

        if (ind == 0)
            return (arr[0] == target);

        boolean not_take = f(ind - 1, target, arr);
        boolean take = false;
        if (target >= arr[ind]) {
            take = f(ind - 1, target - arr[ind], arr);
        }

        return (take || not_take);
    }

    // Memoization
    public static boolean subsetSumToK_M(int n, int target, int[] arr) {
        int dp[][] = new int[n][target + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, target, arr, dp);
    }

    private static boolean f(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;

        if (ind == 0)
            return (arr[0] == target);

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;
        boolean not_take = f(ind - 1, target, arr);
        boolean take = false;
        if (target >= arr[ind]) {
            take = f(ind - 1, target - arr[ind], arr);
        }

        return (take || not_take);
    }

    // Tabulation
    public static boolean subsetSumToK_T(int n, int k, int[] arr) {
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target)
                    taken = dp[ind - 1][target - arr[ind]];

                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];
    }

    // Space Optimization
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean prev[] = new boolean[k + 1];

        prev[0] = true;

        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean cur[] = new boolean[k + 1];
            cur[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTaken = prev[target];

                boolean taken = false;
                if (arr[ind] <= target)
                    taken = prev[target - arr[ind]];

                cur[target] = notTaken || taken;
            }
            prev = cur;

        }

        return prev[k];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target:");
        int target = sc.nextInt();
        System.out
                .println("There exist a subset with sum equal to target(Recursion): " + subsetSumToK_R(n, target, arr));
        System.out.println(
                "There exist a subset with sum equal to target(Memoization): " + subsetSumToK_M(n, target, arr));
        System.out.println(
                "There exist a subset with sum equal to target(Tabulation): " + subsetSumToK_T(n, target, arr));
        System.out.println(
                "There exist a subset with sum equal to target(Space Optimization): " + subsetSumToK(n, target, arr));
    }

}
