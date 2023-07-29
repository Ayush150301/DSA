import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Maximum_sum_of_non_adjacent_elements {

    // Recursion Method
    public static int f(int ind, ArrayList<Integer> nums) {
        if (ind == 0)
            return nums.get(ind);
        if (ind < 0) {
            return 0;
        }
        int pick = nums.get(ind) + f(ind - 2, nums);
        int not_pick = 0 + f(ind - 1, nums);
        return Math.max(pick, not_pick);
    }

    // Memoization Method
    public static int maximumNonAdjacentSum_M(ArrayList<Integer> nums) {
        int dp[] = new int[nums.size() + 1];
        Arrays.fill(dp, -1);
        return f2(nums.size() - 1, nums, dp);
    }

    public static int f2(int ind, ArrayList<Integer> nums, int dp[]) {
        if (ind == 0)
            return nums.get(ind);
        if (ind < 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pick = nums.get(ind) + f2(ind - 2, nums, dp);
        int not_pick = 0 + f2(ind - 1, nums, dp);
        return dp[ind] = Math.max(pick, not_pick);
    }

    // Tabulation Method
    public static int maximumNonAdjacentSum_T(ArrayList<Integer> nums) {
        int dp[] = new int[nums.size()];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);
        int neg = 0;
        for (int i = 1; i < nums.size(); i++) {
            int pick = nums.get(i);
            if (i > 1) {
                pick += dp[i - 2];
            }
            int not_pick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[nums.size() - 1];
    }

    // Space Optimization Method 
    public static int maximumNonAdjacentSum_SO(ArrayList<Integer> nums) {
        int prev = nums.get(0);
        int prev2 = 0;
        for (int i = 1; i < nums.size(); i++) {
            int pick = nums.get(i);
            if (i > 1) {
                pick += prev2;
            }
            int not_pick = 0 + prev;
            int curi = Math.max(pick, not_pick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n  --> ");
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println("Enter the elements of the array ->");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        System.out.println("The Maximum Sum of the subsequence is (Recursion) -->" + f(n - 1, nums));
        System.out.println("The Maximum Sum of the subsequence is (Memoization) -->" + maximumNonAdjacentSum_M(nums));
        System.out.println("The Maximum Sum of the subsequence is (Tabulation) -->" + maximumNonAdjacentSum_T(nums));
        System.out.println("The Maximum Sum of the subsequence is (Space Optimization) -->" + maximumNonAdjacentSum_SO(nums));
    }

}
