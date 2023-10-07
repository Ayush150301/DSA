import java.util.Arrays;
import java.util.Scanner;

public class Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int count[] = new int[n];
        Arrays.fill(count, 1);

        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && 1 + dp[j] == dp[i]) {
                    count[i] = count[i] + count[j];
                }
            }
            maxi = Math.max(dp[i], maxi);
        }
        int nos = 0;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] == maxi)
                nos += count[i];
        }

        return nos;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Number_of_Longest_Increasing_Subsequence obj = new Number_of_Longest_Increasing_Subsequence();
        System.out.println("The number of Longest Increasing Subsequences are : " + obj.findNumberOfLIS(arr));
    }
}
