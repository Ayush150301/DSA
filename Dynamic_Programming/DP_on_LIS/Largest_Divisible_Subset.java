import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i;
            for (int prev = 0; prev <= i - 1; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> l = new ArrayList<>();
        l.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            l.add(nums[lastIndex]);
        }

        Collections.reverse(l);

        return l;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        Largest_Divisible_Subset obj = new Largest_Divisible_Subset();
        System.out.println("The divisble subset is " + obj.largestDivisibleSubset(nums));
    }
}
