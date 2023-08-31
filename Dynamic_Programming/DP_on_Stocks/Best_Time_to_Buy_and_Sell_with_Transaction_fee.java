import java.util.Arrays;
import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_with_Transaction_fee {
    // Recursion
    public int maxProfit_R(int[] prices, int fee) {
        int buy = 0;
        int ind = 0;
        return f(prices, buy, ind, fee);
    }

    public int f(int[] prices, int buy, int ind,int fee) {
        if (ind == prices.length)
            return 0;

        int profit = 0;
        if (buy == 0)
            profit = Math.max(-prices[ind] + f(prices, 1, ind + 1,fee), 0 + f(prices, 0, ind + 1,fee));// buy
        if (buy == 1)
            profit = Math.max(prices[ind]-fee + f(prices, 0, ind + 1,fee), 0 + f(prices, 1, ind + 1,fee));// sell
        return profit;
    }

    // Memoization
    public int maxProfit_M(int[] prices, int fee) {
        int buy = 0;
        int ind = 0;
        int dp[][] = new int[prices.length][2];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(prices, buy, ind,fee, dp);
    }
    public int f(int[] prices, int buy, int ind, int fee, int[][] dp) {
        if (ind == prices.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];
        int profit = 0;
        if (buy == 0)
            profit = Math.max(-prices[ind] + f(prices, 1, ind + 1,fee, dp), 0 + f(prices, 0, ind + 1,fee, dp));// buy
        if (buy == 1)
            profit = Math.max(prices[ind]-fee + f(prices, 0, ind + 1,fee, dp), 0 + f(prices, 1, ind + 1,fee, dp));// sell
        return dp[ind][buy] = profit;
    }

    // Tabulation
    public int maxProfit_T(int[] prices, int fee) {
        int dp[][] = new int[prices.length + 1][2];
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0)
                    profit = Math.max(-prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);// buy
                if(j==1)
                    profit = Math.max(prices[i]-fee + dp[i + 1][0], 0 + dp[i + 1][1]);// sell

                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }

    // Space ptimization
    public int maxProfit(int[] prices, int fee) {
        int prev[] = new int[2];
        int cur[] = new int[2];
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0)
                    profit = Math.max(-prices[i] + prev[1], 0 + prev[0]);// buy
                if(j==1)
                    profit = Math.max(prices[i]-fee + prev[0], 0 + prev[1]);// sell

                cur[j] = profit;
            }
            prev = cur;
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
        System.out.print("Enter the transaction fee: ");
        int fee = sc.nextInt();
        Best_Time_to_Buy_and_Sell_with_Transaction_fee obj = new Best_Time_to_Buy_and_Sell_with_Transaction_fee();
        System.out.println("Maximum profit is(Recursion) :  " + obj.maxProfit_R(prices, fee));
        System.out.println();
        System.out.println("Maximum profit is(Memoization) :  " + obj.maxProfit_M(prices, fee));
        System.out.println();
        System.out.println("Maximum profit is(Tabulation) :  " + obj.maxProfit_T(prices, fee));
        System.out.println();
        System.out.println("Maximum profit is(Space Optimization) :  " + obj.maxProfit(prices, fee));
        System.out.println();
    }
}
