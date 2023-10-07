import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Burst_Balloons {
    // Recursion
    public int maxCoins_R(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.add(1);
        list.add(0, 1);
        Object[] arr = list.toArray();
        return f(1, nums.length, arr);
    }

    private int f(int i, int j, Object[] arr) {
        if (i > j)
            return 0;
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = ((int) arr[i - 1] * (int) arr[ind] * (int) arr[j + 1]) + f(i, ind - 1, arr)
                    + f(ind + 1, j, arr);
            maxi = Math.max(maxi, coins);
        }
        return maxi;
    }

    // Memoization
    public int maxCoins_M(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.add(1);
        list.add(0, 1);
        Object[] arr = list.toArray();
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, nums.length, arr, dp);
    }

    private int f(int i, int j, Object[] arr, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = ((int) arr[i - 1] * (int) arr[ind] * (int) arr[j + 1]) + f(i, ind - 1, arr, dp)
                    + f(ind + 1, j, arr, dp);
            maxi = Math.max(maxi, coins);
        }
        return dp[i][j] = maxi;
    }

    // Tabulation
    public int maxCoins_T(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.add(1);
        list.add(0, 1);
        Object[] arr = list.toArray();
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = nums.length; i >= 1; i--) {
            for (int j = 1; j <= nums.length; j++) {
                if (i > j)
                    continue;
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = ((int) arr[i - 1] * (int) arr[ind] * (int) arr[j + 1]) + dp[i][ind - 1]
                            + dp[ind + 1][j];
                    maxi = Math.max(maxi, coins);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][nums.length];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of balloons : ");
        int size = sc.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        Burst_Balloons obj = new Burst_Balloons();
        System.out.println("\nMaximum coins that can be bursted are(Recursion) --> " + obj.maxCoins_R(nums));
        System.out.println("\nMaximum coins that can be bursted are(Memoization) --> " + obj.maxCoins_M(nums));
        System.out.println("\nMaximum coins that can be bursted are(Tabulation) --> " + obj.maxCoins_T(nums));

    }
}
