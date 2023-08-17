import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change_2 {
    // Recursion
    public int change_R(int amount, int[] coins) {
        int n = coins.length;
        return f(n - 1, coins, amount);
    }

    private int f(int ind, int[] coins, int amount) {
        if (ind == 0) {
            if (amount % coins[ind] == 0)
                return 1;
            else
                return 0;
        }

        int not_take = (f(ind - 1, coins, amount));
        int take = 0;
        if (coins[ind] <= amount)
            take = (f((ind), coins, amount - coins[ind]));

        return take + not_take;

    }

    // Memoization
    public int change_M(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, coins, amount, dp);
    }

    private int f(int ind, int[] coins, int amount, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[ind] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int not_take = f(ind - 1, coins, amount, dp);
        int take = 0;
        if (coins[ind] <= amount)
            take = f(ind, coins, amount - coins[ind], dp);

        return take + not_take;
    }

    // Tabulation
    public int change_T(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0)
                dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (coins[i] <= j)
                    take = dp[i][j - coins[i]];

                dp[i][j] = take + not_take;
            }
        }
        return dp[n - 1][amount];
    }

    // Space Optimization
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0)
                prev[i] = 1;

        for (int i = 1; i < n; i++) {
            int cur[]=new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int not_take = prev[j];
                int take = 0;
                if (coins[i] <= j)
                    take = cur[j - coins[i]];

                cur[j] = take + not_take;
            }
            prev=cur;
        }
        return prev[amount];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount : ");
        int amount = sc.nextInt();
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int coins[] = new int[size];
        System.out.print("Enter the elements of the array : ");
        for (int i = 0; i < coins.length; ++i)
            coins[i] = sc.nextInt();
        Coin_Change_2 obj = new Coin_Change_2();
        System.out.println("The number of Combination are(Recursion) : " + obj.change_R(amount, coins));
        System.out.println("The number of Combination are(Memoization) : " + obj.change_M(amount, coins));
        System.out.println("The number of Combination are(Tabulation) : " + obj.change_T(amount, coins));
        System.out.println("The number of Combination are(Space Optimization) : " + obj.change(amount, coins));

    }
}
