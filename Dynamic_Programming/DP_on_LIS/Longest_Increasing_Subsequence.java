import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Longest_Increasing_Subsequence {
    // Recursion
    public int f(int nums[], int ind, int prev) {
        if (ind == nums.length) {
            return 0;
        }
        int take = 0;
        int not_take = 0 + f(nums, ind + 1, prev);
        if (prev == -1 || nums[ind] > nums[prev])
            take = 1 + f(nums, ind + 1, ind);

        return Math.max(take, not_take);

    }

    public int lengthOfLIS_R(int[] nums) {
        return f(nums, 0, -1);
    }

    // Memoization
    public int lengthOfLIS_M(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(nums, 0, -1, dp);
    }

    private int f(int[] nums, int ind, int prev, int[][] dp) {
        if (ind == nums.length) {
            return 0;
        }
        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];

        int take = 0;
        int not_take = 0 + f(nums, ind + 1, prev, dp);
        if (prev == -1 || nums[ind] > nums[prev])
            take = 1 + f(nums, ind + 1, ind, dp);

        return dp[ind][prev + 1] = Math.max(take, not_take);

    }

    // Tabulation
    public int lengthOfLIS_T(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];

        for (int ind = nums.length - 1; ind >= -1; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int len = 0 + dp[ind + 1][prev + 1];
                if (prev == -1 || nums[ind] >= nums[prev])
                    len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
                dp[ind][prev + 1] = len;
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    // space complexity -->O(n*2)
    public int lengthOfLIS(int[] nums) {
        int next[] = new int[nums.length + 1];
        int cur[] = new int[nums.length + 1];

        for (int ind = nums.length - 1; ind >= -1; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int len = 0 + next[prev + 1];
                if (prev == -1 || nums[ind] >= nums[prev])
                    len = Math.max(len, 1 + next[ind + 1]);
                cur[prev + 1] = len;
            }
            next = cur;
        }
        return next[0];
    }

    // better approaches with space optimization but no change int time complexity
    // space complexity --> O(n)
    // time complexity --> O(n^2)
    public int lengthOfLIS_T2(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int ind = 0; ind < nums.length; ind++) {
            for (int prev = 0; prev <= ind - 1; prev++) {
                if (nums[prev] <= nums[ind]) {
                    dp[ind] = Math.max(1 + dp[prev], dp[ind]);
                }
            }
        }
        int ans = -1;

        for (int i = 0; i <= nums.length - 1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // Approach Binary Search
    public int lower(int array[], int key) {
        int lowerBound = 0;

        // Traversing the array using length function
        while (lowerBound < array.length) {

            // If key is lesser than current value
            if (key > array[lowerBound])
                lowerBound++;

            // This is either the first occurrence of key
            // or value just greater than key
            else
                return lowerBound;
        }

        return lowerBound;
    }

    public int lengthOfLIS_binay_search(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Longest_Increasing_Subsequence obj = new Longest_Increasing_Subsequence();
        System.out.println(
                "The length of the longest strictly increasing subsequence(Recursion) : " + obj.lengthOfLIS_R(nums));
        System.out.println(
                "The length of the longest strictly increasing subsequence(Memoization) : " + obj.lengthOfLIS_M(nums));
        System.out.println(
                "The length of the longest strictly increasing subsequence(Tabulation) : " + obj.lengthOfLIS_T(nums));
        System.out.println("The length of the longest strictly increasing subsequence(Space Optimization) : "
                + obj.lengthOfLIS(nums));
        System.out.println("The length of the longest strictly increasing subsequence(better Space Optimization) : "
                + obj.lengthOfLIS_T2(nums));
        System.out.println("The length of the longest strictly increasing subsequence(Binary search) : "
                + obj.lengthOfLIS_binay_search(nums));
    }
}