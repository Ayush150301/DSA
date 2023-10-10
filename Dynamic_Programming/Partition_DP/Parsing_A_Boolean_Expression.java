import java.util.Arrays;
import java.util.Scanner;

public class Parsing_A_Boolean_Expression {
    static final int MOD = 1000000007;

    // Recursion
    public static int f(int i, int j, int isTrue, String exp) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return (exp.charAt(i) == 'T') ? 1 : 0;
            else
                return (exp.charAt(i) == 'F') ? 1 : 0;
        }
        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long LT = f(i, ind - 1, 1, exp);
            long LF = f(i, ind - 1, 0, exp);
            long RT = f(ind + 1, j, 1, exp);
            long RF = f(ind + 1, j, 0, exp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD + (LF * RF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD + (LT * RT) % MOD) % MOD;
                }
            }
        }
        return (int) ways;
    }

    public static int evaluateExp_R(String exp) {
        return f(0, exp.length() - 1, 1, exp);
    }

    // Memoization
    public static long f(int i, int j, int isTrue, String exp, long dp[][][]) {
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == 1)
                return (exp.charAt(i) == 'T') ? 1 : 0;
            else
                return (exp.charAt(i) == 'F') ? 1 : 0;
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long LT = f(i, ind - 1, 1, exp, dp);
            long LF = f(i, ind - 1, 0, exp, dp);
            long RT = f(ind + 1, j, 1, exp, dp);
            long RF = f(ind + 1, j, 0, exp, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD + (LF * RF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (LF * RT) % MOD + (LT * RF) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD + (LT * RT) % MOD) % MOD;
                }
            }
        }
        dp[i][j][isTrue] = ways;
        return ways;
    }

    public static int evaluateExp_M(String exp) {
        int n = exp.length();
        long dp[][][] = new long[n][n][2];
        for (long row[][] : dp) {
            for (long rows[] : row) {
                Arrays.fill(rows, -1);
            }
        }
        return (int) f(0, exp.length() - 1, 1, exp, dp);
    }

    // Tabulation
    public static int evaluateExp_T(String exp) {
        int n = exp.length();
        long[][][] dp = new long[n][n][2];

        // Initializing the dp array
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                if (i > j) continue;
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    // Base case 1:
                    if (i == j) {
                        if (isTrue == 1) dp[i][j][isTrue] = exp.charAt(i) == 'T' ? 1 : 0;
                        else dp[i][j][isTrue] = exp.charAt(i) == 'F' ? 1 : 0;
                        continue;
                    }

                    // Recurrence logic:
                    long ways = 0;
                    for (int ind = i + 1; ind <= j - 1; ind += 2) {
                        long lT = dp[i][ind - 1][1];
                        long lF = dp[i][ind - 1][0];
                        long rT = dp[ind + 1][j][1];
                        long rF = dp[ind + 1][j][0];

                        char operator = exp.charAt(ind);
                        if (operator == '&') {
                            if (isTrue == 1) ways = (ways + (lT * rT) % MOD) % MOD;
                            else ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                        } else if (operator == '|') {
                            if (isTrue == 1) ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;
                            else ways = (ways + (lF * rF) % MOD) % MOD;
                        } else {
                            if (isTrue == 1) ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;
                            else ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return (int) dp[0][n - 1][1];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        System.out.println("The Expression is(Recursion): " + evaluateExp_R(str));
        System.out.println("The Expression is(Memoization): " + evaluateExp_M(str));
        System.out.println("The Expression is(Tabulation): " + evaluateExp_T(str));
    }
}
