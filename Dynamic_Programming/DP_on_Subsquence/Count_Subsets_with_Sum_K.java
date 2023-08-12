import java.util.Arrays;
import java.util.Scanner;

public class Count_Subsets_with_Sum_K {
    // Recursion
    public static int findWays_R(int num[], int tar) {
        int count = 0;
        int n = num.length;
        return f(n - 1, num, tar);
    }

    private static int f(int n, int[] num, int tar) {
        if(tar==0)
        return 1;

        if(n==0)
        return num[0]==tar?1:0;
        int not_take = f(n - 1, num, tar);
        int take=0;
        if(num[n]<=tar)
        take = f(n - 1, num, tar - num[n]);

        return take+not_take;

    }

    // Memoization
    public static int findWays_M(int num[], int tar) {
        int n=num.length;
        int dp[][]=new int[n][tar+1];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return f(n-1,num,tar,dp);
    }

    private static int f(int n, int[] num, int tar, int[][] dp) {
        if(tar==0)
        return 1;

        if(n==0)
        return num[0]==tar?1:0;

        if(dp[n][tar]!=-1)
        return dp[n][tar];
        int not_take = f(n - 1, num, tar,dp);
        int take=0;
        if(num[n]<=tar)
        take = f(n - 1, num, tar - num[n],dp);

        return dp[n][tar]=take+not_take;
    }

    // Tabulation
    public static int findWays_T(int num[], int tar) {
        int n=num.length;
        int dp[][]=new int[n][tar+1];

        for(int i=0;i<num.length;i++)
        {
            dp[i][0]=1;
        }

        if(num[0]<=tar)
        {
            dp[0][num[0]]=1;
        }

        for(int i=1;i<n;i++)
        {
            for(int target=1;target<=tar;target++)
            {
                int not_take=dp[i-1][target];

                int take=0;
                if(num[i]<=target)
                {
                    take=dp[i-1][target-num[i]];
                }
                dp[i][target]=not_take+take;
            }
        }
        return dp[n-1][tar];
    }

    // Space Optimization
    public static int findWays(int num[], int tar) {
        int n=num.length;
        int prev[]=new int[tar+1];

        prev[0]=1;

        if(num[0]<=tar)
        {
            prev[num[0]]=1;
        }
        for(int i=1;i<n;i++)
        {
            int cur[]=new int[tar+1];
            cur[0]=1;
            for(int j=1;j<=tar;j++)
            {
                int not_take=prev[j];

                int take=0;
                if(num[i]<=j)
                {
                    take=prev[j-num[i]];
                }
                cur[j]=take+not_take;
            }
            prev=cur;
        }
        return prev[tar];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.print("\n Enter sum k: ");
        int s = sc.nextInt();
        System.out.println("The number of ways of selecting elements are(Recursion) :" + findWays_R(arr, s));
        System.out.println("The number of ways of selecting elements are(Memoization) :" + findWays_M(arr, s));
        System.out.println("The number of ways of selecting elements are(Tabulation) :" + findWays_T(arr, s));
        System.out.println("The number of ways of selecting elements are(Space Optimization) :" + findWays(arr, s));
    }
}
