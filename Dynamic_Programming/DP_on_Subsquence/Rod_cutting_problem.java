import java.util.Arrays;
import java.util.Scanner;

public class Rod_cutting_problem {
    // Recusrion
    public static int cutRod_R(int price[], int n) {
        return f(n - 1, price, n);
    }

    private static int f(int ind, int[] price, int length) {
        if (ind == 0)
            return length * price[0];

        int not_take = 0 + f(ind - 1, price, length);
        int take = Integer.MIN_VALUE;
        int rodlength = ind + 1;
        if (rodlength <= length)
            take = price[ind] + f(ind, price, length - rodlength);

        return Math.max(not_take, take);
    }

    // Memoization
    public static int cutRod_M(int price[], int n) {
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, price, n, dp);
    }

    private static int f(int ind, int price[], int length, int dp[][]) {
        if (ind == 0)
            return length * price[0];

        if (dp[ind][length] != -1)
            return dp[ind][length];

        int not_take = 0 + f(ind - 1, price, length);
        int take = Integer.MIN_VALUE;
        int rodlength = ind + 1;
        if (rodlength <= length)
            take = price[ind] + f(ind, price, length - rodlength);

        return dp[ind][length] = Math.max(not_take, take);
    }

    // Tabulation
    public static int cutRod_T(int price[], int n) {
        int dp[][] = new int[n][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int not_take = 0 + dp[i-1][j];
                int take = Integer.MIN_VALUE;
                int rodlength = i + 1;
                if (rodlength <= j)
                    take = price[i] + dp[i][j-rodlength];

                dp[i][j] = Math.max(not_take, take);
            }
        }
        return dp[n-1][n];
    }

    // Space Optimization
    public static int cutRod(int price[], int n) {
        int prev[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int not_take = 0 + prev[j];
                int take = Integer.MIN_VALUE;
                int rodlength = i + 1;
                if (rodlength <= j)
                    take = price[i] + prev[j-rodlength];

                prev[j] = Math.max(not_take, take);
            }
        }
        return prev[n];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of rod");
        int l = sc.nextInt();
        int[] price = new int[l];
        System.out.println("Enter the price length : ");
        for (int i = 0; i < l; ++i)
            price[i] = sc.nextInt();
        System.out.println("The maximum Cost obtained(Recursion) : " + cutRod_R(price, l));
        System.out.println("The maximum Cost obtained(Memoization) : " + cutRod_M(price, l));
        System.out.println("The maximum Cost obtained(Tabulation) : " + cutRod_T(price, l));
        System.out.println("The maximum Cost obtained(Space Optimization) : " + cutRod(price, l));
    }
}
