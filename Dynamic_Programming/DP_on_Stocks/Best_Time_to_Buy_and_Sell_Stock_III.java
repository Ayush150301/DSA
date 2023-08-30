import java.util.Arrays;
import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_III {
    // Recursion
    public int maxProfit_R(int[] prices) {
        int ind = 0;
        int buy = 0;
        int cap = 2;
        return f(prices, ind, buy, cap);
    }

    public int f(int[] prices, int ind, int buy, int cap) {
        if (ind == prices.length || cap == 0) {
            return 0;
        }

        int profit = 0;
        if (buy == 0) {
            profit = Math.max(-prices[ind] + f(prices, ind + 1, 1, cap), 0 + f(prices, ind + 1, 0, cap));
        }
        if (buy == 1) {
            profit = Math.max(prices[ind] + f(prices, ind + 1, 0, cap - 1), 0 + f(prices, ind + 1, 1, cap));
        }
        return profit;
    }

    // Memoization
    public int maxProfit_M(int[] prices) {
        int ind = 0;
        int buy = 0;
        int cap = 2;
        int dp[][][] = new int[prices.length][2][3];
        for(int row[][]:dp)
        {
            for(int col[]:row)
            {
                Arrays.fill(col,-1);
            }
        }
        return f(prices, ind, buy, cap, dp);
    }

    private int f(int[] prices, int ind, int buy, int cap, int[][][] dp) {
        if (ind == prices.length || cap == 0) {
            return 0;
        }

        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if (buy == 0) { // buy
            profit = Math.max(-prices[ind] + f(prices, ind + 1, 1, cap, dp), 0 + f(prices, ind + 1, 0, cap, dp));
        }
        if (buy == 1) { // sell
            profit = Math.max(prices[ind] + f(prices, ind + 1, 0, cap - 1, dp), 0 + f(prices, ind + 1, 1, cap, dp));
        }
        return dp[ind][buy][cap] = profit;
    }

    // Tabulation
    public int maxProfit_T(int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {// We can buy the stock
                        dp[i][buy][cap] = Math.max(0 + dp[i + 1][0][cap], -prices[i] + dp[i + 1][1][cap]);
                    }

                    if (buy == 1) {// We can sell the stock
                        dp[i][buy][cap] = Math.max(0 + dp[i + 1][1][cap], prices[i] + dp[i + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }

    // Space Optimization
    public int maxProfit(int[] prices) {
        int ahead[][] = new int[2][3];
        int cur[][] = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {// We can buy the stock
                        cur[buy][cap] = Math.max(0+ahead[0][cap],-prices[i]+ahead[1][cap]);
                    }

                    if (buy == 1) {// We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap], prices[i] + cur[0][cap - 1]);
                    }
                }
            }
            ahead=cur;
        }
        return ahead[0][2];
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
        Best_Time_to_Buy_and_Sell_Stock_III obj = new Best_Time_to_Buy_and_Sell_Stock_III();
        System.out.println("The Maximum Profit (Recursion): " + obj.maxProfit_R(prices));
        System.out.println("The Maximum Profit (Memoization): " + obj.maxProfit_M(prices));
        System.out.println("The Maximum Profit (Tabulation): " + obj.maxProfit_T(prices));
        System.out.println("The Maximum Profit (Space Optimization): " + obj.maxProfit(prices));
    }
}
