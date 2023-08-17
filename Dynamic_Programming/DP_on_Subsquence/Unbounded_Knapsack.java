import java.util.Arrays;
import java.util.Scanner;

public class Unbounded_Knapsack {
    // Recursion
    public static int unboundedKnapsack_R(int n, int w, int[] profit, int[] weight) {
        return f(n - 1, w, profit, weight);
    }

    private static int f(int ind, int w, int[] profit, int[] weight) {
        if (ind == 0) {
            return ((int) w / weight[0]) * profit[0];
        }

        int not_take = f(ind - 1, w, profit, weight);

        int take = 0;
        if (weight[ind] <= w)
            take = profit[ind] + f(ind, w - weight[ind], profit, weight);

        return Math.max(take, not_take);
    }

    // Memoization
    public static int unboundedKnapsack_M(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n][w + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(n - 1, w, profit, weight, dp);
    }

    private static int f(int ind, int w, int[] profit, int[] weight, int[][] dp) {
        if (ind == 0) {
            return ((int) w / weight[0]) * profit[0];
        }

        if (dp[ind][w] != -1)
            return dp[ind][w];

        int not_take = f(ind - 1, w, profit, weight, dp);

        int take = 0;
        if (weight[ind] <= w)
            take = profit[ind] + f(ind, w - weight[ind], profit, weight, dp);

        return dp[ind][w] = Math.max(take, not_take);
    }

    // Tabulation
    public static int unboundedKnapsack_T(int n, int w, int[] profit, int[] weight) {
        int dp[][]=new int[n][w+1];
        for(int i=weight[0]; i<=w; i++){
            dp[0][i] = ((int) i/weight[0]) * profit[0];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=w;j++)
            {
                int not_take=0+dp[i-1][j];

                int take=Integer.MIN_VALUE;
                if(weight[i]<=j)
                take=profit[i]+dp[i][j-weight[i]];
                dp[i][j]=Math.max(not_take,take);
            }
        }
        return dp[n-1][w];
    }

    // Space Optimization
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int prev[]=new int[w+1];
        for(int i=weight[0]; i<=w; i++){
            prev[i] = ((int) i/weight[0]) * profit[0];
        }

        for(int i=1;i<n;i++)
        {
            int cur[]=new int[w+1];
            for(int j=0;j<=w;j++)
            {
                int not_take=0+prev[j];

                int take=Integer.MIN_VALUE;
                if(weight[i]<=j)
                take=profit[i]+cur[j-weight[i]];
                cur[j]=Math.max(not_take,take);
            }
            prev=cur;
        }
        return prev[w];
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
        int profit[] = new int[n];
        for (int j = 0; j < profit.length; ++j) {
            profit[j] = sc.nextInt();
        }
        System.out.println("Enter maximum capacity:");
        int maxWeight = sc.nextInt();
        System.out.println("The maximum value(Recursion) : " + unboundedKnapsack_R(n, maxWeight, profit, weight));
        System.out.println("The maximum value(Memoization) : " + unboundedKnapsack_M(n, maxWeight, profit, weight));
        System.out.println("The maximum value(Tabulation) : " + unboundedKnapsack_T(n, maxWeight, profit, weight));
        System.out
                .println("The maximum value(Space Optimization) : " + unboundedKnapsack(n, maxWeight, profit, weight));
    }
}
