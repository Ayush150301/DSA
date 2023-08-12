import java.util.Arrays;
import java.util.Scanner;

public class Partitions_With_Given_Difference {
    static int mod = (int) Math.pow(10, 9) + 7;

    // Recursion
    public static int countPartitions_R(int n, int d, int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int target = (total - d) / 2;
        if ((total - d < 0) || (total - d) % 2 == 1)
            return 0;
        return f(n - 1, arr, target)%mod;
    }

    private static int f(int n, int[] arr, int target) {
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
        return f(n - 1, arr, target, dp)%mod;
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
                dp[i][j]=(not_take+take)%mod;
            }
        }
        return dp[n-1][target];
    }

    // Space Optimization
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
                cur[j]=(not_take+take)%mod;
            }
            prev=cur;
        }
        return prev[target];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.print("\n Enter difference k: ");
        int d = sc.nextInt();
        System.out.println("Number of Partitons(Recursion) :" + countPartitions_R(n, d, arr));
        System.out.println("Number of Partitons(Memoization) :" + countPartitions_M(n, d, arr));
        System.out.println("Number of Partitons(Tabulation) :" + countPartitions_T(n, d, arr));
        System.out.println("Number of Partitons(Space Optimization) :" + countPartitions(n, d, arr));
    }
}
