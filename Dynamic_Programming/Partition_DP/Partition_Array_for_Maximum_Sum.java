import java.util.Arrays;
import java.util.Scanner;

public class Partition_Array_for_Maximum_Sum {
    //Recursion
    public int maxSumAfterPartitioning_R(int[] arr, int k) {
        return f(0, arr, k);

    }
    private int f(int ind, int[] arr, int k) {
        int n = arr.length;
        // Base case:
        if (ind == n) return 0;

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + f(j + 1, arr, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
    //Memoization
    public int maxSumAfterPartitioning_M(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, arr, k, dp);
    }
    private int f(int ind, int[] arr, int k, int[] dp) {
        int n = arr.length;
        // Base case:
        if (ind == n) return 0;

        if (dp[ind] != -1) return dp[ind];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + f(j + 1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
    //Tabulation
    public int maxSumAfterPartitioning_T(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            
            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the arrays : ");
        int size = sc.nextInt();
        // Input array elements
        int[] arr = new int[size];
        System.out.println("Enter the elements of the arrays : ");
        for (int i = 0;i < size ;i++ )
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the value of k : ");
        int k=sc.nextInt();
        Partition_Array_for_Maximum_Sum obj=new Partition_Array_for_Maximum_Sum();
        System.out.println("The maximum sum after partitioning is (Recursion) "+obj.maxSumAfterPartitioning_R(arr,k));
        System.out.println("The maximum sum after partitioning is (Memoization) "+obj.maxSumAfterPartitioning_M(arr,k));
        System.out.println("The maximum sum after partitioning is (Tabulation) "+obj.maxSumAfterPartitioning_T(arr,k));
    }
}
