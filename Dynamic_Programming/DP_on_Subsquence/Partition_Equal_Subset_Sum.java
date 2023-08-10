import java.util.Arrays;
import java.util.Scanner;

public class Partition_Equal_Subset_Sum {
    // Recurison
    public boolean canPartition_R(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        return f(nums.length - 1, target, nums);
    }

    private boolean f(int ind, int target, int[] arr) {
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
    public boolean canPartition_M(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1)
            return false;
        else {
            int target = sum / 2;
            int dp[][] = new int[n][target + 1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return f(n - 1, target, nums, dp);
        }
    }

    private boolean f(int ind, int target, int[] arr, int[][] dp) {
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
    public boolean canPartition_T(int[] nums) {
        int n = nums.length;
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;
            boolean dp[][] = new boolean[n][k + 1];

            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            if (nums[0] <= k)
                dp[0][nums[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {

                    boolean notTaken = dp[ind - 1][target];

                    boolean taken = false;
                    if (nums[ind] <= target)
                        taken = dp[ind - 1][target - nums[ind]];

                    dp[ind][target] = notTaken || taken;
                }
            }
            return dp[n - 1][k];
        }
    }

    // Space Optimization
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;
            boolean prev[] = new boolean[k + 1];

            prev[0] = true;

            if (nums[0] <= k)
                prev[nums[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];

                    boolean taken = false;
                    if (nums[ind] <= target)
                        taken = prev[target - nums[ind]];

                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }
            return prev[k];
        }
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Partition_Equal_Subset_Sum obj = new Partition_Equal_Subset_Sum();
        System.out.println(" The sum of the elements in both subsets is equal(Recursion):" + obj.canPartition_R(arr));
        System.out.println(" The sum of the elements in both subsets is equal(Memoization):" + obj.canPartition_M(arr));
        System.out.println(" The sum of the elements in both subsets is equal(Tabulation):" + obj.canPartition_T(arr));
        System.out.println(
                " The sum of the elements in both subsets is equal(Space Optimization):" + obj.canPartition(arr));
    }
}
