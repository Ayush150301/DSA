public int maxProfit_T(int[] prices) {
    int dp[][] = new int[prices.length + 1][2];
    // Base case
    dp[0][0] = dp[0][1] = 0;
    int profit =0;
    for (int i = prices.length - 1; i >= 0; i--) {
    for (int j = 0; j <= 1; j++) {
    if (j == 1)
    profit = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);// buy
    else
    profit = Math.max(prices[i] + dp[i+1][1], 0 + dp[i+1][0]);// sell

    dp[i][j]=profit;
    }
    }
    return dp[0][1];
    }