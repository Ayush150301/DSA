import java.util.Arrays;
import java.util.Scanner;

public class Target_Sum {
    // Recursion
    public int findTargetSumWays_R(int[] nums, int target) {
        return countPartitions_R(nums.length, target, nums);
    }

    public int countPartitions_R(int n, int d, int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int target = (total - d) / 2;
        if ((total - d < 0) || (total - d) % 2 == 1)
            return 0;
        return f(n - 1, arr, target);
    }

    private int f(int n, int[] arr, int target) {
        if (n == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        int not_take = f(n - 1, arr, target);
        int take = 0;
        if (arr[n] <= target)
            take = f(n - 1, arr, target - arr[n]);

        return take + not_take;
    }
    // Memoization
    public int findTargetSumWays_M(int[] nums, int target) {
        return countPartitions_M(nums.length, target, nums);
    }

    public static int countPartitions_M(int n, int d, int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int target = (total - d) / 2;
        if ((total - d < 0) || (total - d) % 2 == 1)
            return 0;
        int dp[][] = new int[n][target + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(n - 1, arr, target, dp);
    }

    private static int f(int n, int[] arr, int target, int[][] dp) {
        if (n == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[n][target] != -1)
            return dp[n][target];

        int not_take = f(n - 1, arr, target, dp);
        int take = 0;
        if (arr[n] <= target)
            take = f(n - 1, arr, target - arr[n], dp);

        return dp[n][target]= take + not_take;
    }
    // Tabulation
    public int findTargetSumWays_T(int[] nums, int target) {
        return countPartitions_T(nums.length, target, nums);
    }
    public static int countPartitions_T(int n, int d, int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int target = (total - d) / 2;
        if ((total - d < 0) || (total - d) % 2 == 1)
            return 0;
        int dp[][]=new int[n][target+1];
        
        if(arr[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if(arr[0]!=0 && arr[0]<=target) 
        {
            dp[0][arr[0]]=1;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                int not_take=dp[i-1][j];

                int take=0;
                if(arr[i]<=j)
                {
                    take=dp[i-1][j-arr[i]];
                }
                dp[i][j]=(not_take+take);
            }
        }
        return dp[n-1][target];
    }

    // Spcae Optimization
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length, target, nums);
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int target = (total - d) / 2;
        if ((total - d < 0) || (total - d) % 2 == 1)
            return 0;
        int prev[]=new int[target+1];
        
        if(arr[0]==0) prev[0]=2;
        else prev[0]=1;
        if(arr[0]!=0 && arr[0]<=target) 
        {
            prev[arr[0]]=1;
        }

        for(int i=1;i<n;i++)
        {
            int cur[]=new int[target+1];

            for(int j=0;j<=target;j++)
            {
                int not_take=prev[j];

                int take=0;
                if(arr[i]<=j)
                {
                    take=prev[j-arr[i]];
                }
                cur[j]=(not_take+take);
            }
            prev=cur;
        }
        return prev[target];
    }
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target : ");
        int target = sc.nextInt();
        Target_Sum ts = new Target_Sum();
        System.out
                .println("The number of different expression are(Recursion) : " + ts.findTargetSumWays_R(nums, target));
        System.out.println(
                "The number of different expression are(Memoization) : " + ts.findTargetSumWays_M(nums, target));
        System.out.println(
                "The number of different expression are(Tabulation) : " + ts.findTargetSumWays_T(nums, target));
        System.out.println(
                "The number of different expression are(Space Optimization) : " + ts.findTargetSumWays(nums, target));
    }

}
