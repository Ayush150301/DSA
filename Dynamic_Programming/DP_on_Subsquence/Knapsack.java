import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    // Recursion
    public static int knapsack_R(int[] weight, int[] value, int n, int maxWeight) {

        return f(weight, value, n - 1, maxWeight);
    }

    private static int f(int[] weight, int[] value, int n, int maxWeight) {
        if (n == 0) {
            if (weight[0] <= maxWeight)
                return value[0];
            else
                return 0;
        }
        int not_take = 0 + f(weight, value, n - 1, maxWeight);

        int take = Integer.MIN_VALUE;
        if (weight[n] <= maxWeight)
            take = value[n] + f(weight, value, n - 1, maxWeight - weight[n]);
        return Math.max(take, not_take);
    }

    // Memoization
    public static int knapsack_M(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(weight, value, n - 1, maxWeight, dp);
    }

    private static int f(int[] weight, int[] value, int ind, int maxWeight, int[][] dp) {
        if (ind == 0) {
            if (weight[0] <= maxWeight)
                return value[0];
            else
                return 0;
        }

        if (dp[ind][maxWeight] != -1)
            return dp[ind][maxWeight];

        int not_take = 0 + f(weight, value, ind - 1, maxWeight, dp);

        int take = Integer.MIN_VALUE;
        if (weight[ind] <= maxWeight)
            take = value[ind] + f(weight, value, ind - 1, maxWeight - weight[ind], dp);
        return dp[ind][maxWeight] = Math.max(take, not_take);
    }

    // Tabulation
    public static int knapsack_T(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][]=new int[n][maxWeight+1];

        for(int i=weight[0];i<=maxWeight;i++)
        {
            dp[0][i]=value[0];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=maxWeight;j++)
            {
                int not_take=0+dp[i-1][j];

                int take=Integer.MIN_VALUE;
                if(weight[i]<=j)
                take=value[i]+dp[i-1][j-weight[i]];
                dp[i][j]=Math.max(not_take,take);
            }
        }
        return dp[n-1][maxWeight];
    }

    // Space Optimization
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int prev[]=new int[maxWeight+1];

        for(int i=weight[0];i<=maxWeight;i++)
        {
            prev[i]=value[0];
        }

        for(int i=1;i<n;i++)
        {
            int cur[]=new int[maxWeight+1];
            for(int j=0;j<=maxWeight;j++)
            {
                int not_take=0+prev[j];

                int take=Integer.MIN_VALUE;
                if(weight[i]<=j)
                take=value[i]+prev[j-weight[i]];
                cur[j]=Math.max(not_take,take);
            }
            prev=cur;
        }
        return prev[maxWeight];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        int weight[] = new int[n];
        System.out.println("Enter the weight of the items :");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter the value of the items :");
        int value[] = new int[n];
        for (int j = 0; j < value.length; ++j) {
            value[j] = sc.nextInt();
        }
        System.out.println("Enter maximum capacity:");
        int maxWeight = sc.nextInt();
        System.out.println("The maximum value(Recursion) : " + knapsack_R(weight, value, n, maxWeight));
        System.out.println("The maximum value(Memoization) : " + knapsack_M(weight, value, n, maxWeight));
        System.out.println("The maximum value(Tabulation) : " + knapsack_T(weight, value, n, maxWeight));
        System.out.println("The maximum value(Space Optimization) : " + knapsack(weight, value, n, maxWeight));
    }
}
