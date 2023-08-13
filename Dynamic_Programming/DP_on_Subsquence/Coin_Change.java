import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change {
    // Recursion
    public int coinChange_R(int[] coins, int amount) {
        int n = coins.length;
        int ans=f(n - 1, coins, amount);
        if(ans >= 1e9) return -1;
        return ans;
    }

    private int f(int ind, int[] coins, int amount) {
        if (ind == 0) {
            if (amount % coins[ind] == 0)
                return amount / coins[ind];
            else
                return (int) Math.pow(10, 9);
        }

        int not_take = 0 + f(ind - 1, coins, amount);
        int take = Integer.MAX_VALUE;
        if (coins[ind] <= amount)
            take = 1 + f(ind, coins, amount - coins[ind]);
        return Math.min(not_take, take);
    }

    // Memoization
    public int coinChange_M(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = f(n - 1, coins, amount, dp);
        if(ans >= 1e9) return -1;
        return ans;
    }

    private int f(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[ind] == 0)
                return amount / coins[ind];
            else
                return (int) Math.pow(10, 9);
        }

        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int not_take = 0 + f(ind - 1, coins, amount,dp);
        int take = Integer.MAX_VALUE;
        if (coins[ind] <= amount)
            take = 1 + f(ind, coins, amount - coins[ind],dp);
        return dp[ind][amount]=Math.min(not_take, take);
    }

    // Tabulation
    public int coinChange_T(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];

        for(int t=0;t<=amount;t++)
        {
            if(t%coins[0]==0)  dp[0][t]=t/coins[0];
            else dp[0][t]=(int) Math.pow(10, 9);
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                int not_take=0+dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j)
                take=1+dp[i][j-coins[i]];
                dp[i][j]=Math.min(not_take,take);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >=1e9) return -1;
        return ans;
    }

    // Space Optimization
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int prev[]=new int[amount+1];

        for(int t=0;t<=amount;t++)
        {
            if(t%coins[0]==0)  prev[t]=t/coins[0];
            else prev[t]=(int) Math.pow(10, 9);
        }

        for(int i=1;i<n;i++)
        {
            int cur[]=new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int not_take=0+prev[j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j)
                take=1+cur[j-coins[i]];
                cur[j]=Math.min(not_take,take);
            }
            prev=cur;
        }
        int ans = prev[amount];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int coins[] = new int[n];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        Coin_Change obj = new Coin_Change();
        System.out.println("The minimum number of coins are(Recursion):" + obj.coinChange_R(coins, amount));
        System.out.println("The minimum number of coins are(Memoization):" + obj.coinChange_M(coins, amount));
        System.out.println("The minimum number of coins are(Tabulation):" + obj.coinChange_T(coins, amount));
        System.out.println("The minimum number of coins are(Space Optimization):" + obj.coinChange(coins, amount));
    }
}
