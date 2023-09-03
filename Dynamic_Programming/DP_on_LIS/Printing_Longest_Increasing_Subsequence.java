import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Printing_Longest_Increasing_Subsequence {
    // only single aaproach by using tabulation and bracktracking
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int hash[] = new int[arr.length];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= x - 1; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }

        }
        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= x - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> l = new ArrayList<>();
        l.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            l.add(arr[lastIndex]);
        }
        Collections.reverse(l);
        return l;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(
                "\nThe longest increasing subsequence is : " + printingLongestIncreasingSubsequence(arr, size));
    }
}
