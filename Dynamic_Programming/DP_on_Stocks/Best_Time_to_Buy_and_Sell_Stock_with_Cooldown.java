import java.util.Arrays;
import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    // Recursion
    public int maxProfit_R(int[] prices) {
        int buy = 0;
        int ind = 0;
        return f(prices, buy, ind);
    }

    public int f(int[] prices, int buy, int ind) {
        if (ind >= prices.length)
            return 0;

        int profit = 0;
        if (buy == 0)
            profit = Math.max(-prices[ind] + f(prices, 1, ind + 1), 0 + f(prices, 0, ind + 1));// buy
        if (buy == 1)
            profit = Math.max(prices[ind] + f(prices, 0, ind + 2), 0 + f(prices, 1, ind + 1));// sell
        return profit;
    }

    // Memoization
    public int maxProfit_M(int[] prices) {
        int buy = 0;
        int ind = 0;
        int dp[][] = new int[prices.length][2];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(prices, buy, ind, dp);
    }

    public int f(int[] prices, int buy, int ind, int[][] dp) {
        if (ind >= prices.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        int profit = 0;
        if (buy == 0)
            profit = Math.max(-prices[ind] + f(prices, 1, ind + 1, dp), 0 + f(prices, 0, ind + 1, dp));// buy
        if (buy == 1)
            profit = Math.max(prices[ind] + f(prices, 0, ind + 2, dp), 0 + f(prices, 1, ind + 1, dp));// sell
        return dp[ind][buy] = profit;
    }

    // Tabulation
    public int maxProfit_T(int[] prices) {
        int dp[][] = new int[prices.length + 2][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 0) //buy
                    profit = Math.max(-prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);// buy
                if (j == 1) //sell
                    profit = Math.max(prices[i] + dp[i + 2][0], 0 + dp[i + 1][1]);// sell

                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    public int maxProfit(int[] prices) {
        int cur[]=new int[2];
        int front1[]=new int[2];
        int front2[]=new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 0) //buy
                    profit = Math.max(-prices[i] + front1[1], 0 + front1[0]);// buy
                if (j == 1) //sell
                    profit = Math.max(prices[i] + front2[0], 0 + front1[1]);// sell

                cur[j] = profit;
            }
            front2=(int[])(front1.clone());
            front1=(int[])(cur.clone());
        }
        return cur[0];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int prices[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }
        Best_Time_to_Buy_and_Sell_Stock_with_Cooldown obj = new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        System.out.println("The Maximum Profit(Recursion) : " + obj.maxProfit_R(prices));
        System.out.println("The Maximum Profit(Memoization) : " + obj.maxProfit_M(prices));
        System.out.println("The Maximum Profit(Tabulation) : " + obj.maxProfit_T(prices));
        System.out.println("The Maximum Profit(Space Optimization) : " + obj.maxProfit(prices));
    }
}
