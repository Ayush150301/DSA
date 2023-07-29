import java.util.Arrays;
import java.util.Scanner;

public class Ninja {
    // Recursion
    public static int f(int ind, int last, int points[][]) {
        if (ind == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[ind][i]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int merit = points[ind][i] + f(ind - 1, last, points);
                maxi = Math.max(maxi, merit);
            }
        }
        return maxi;
    }

    public static int ninjaTraining_R(int n, int points[][]) {
        return f(n - 1, 3, points);
    }

    // Memoization
    public static int f_M(int ind, int last, int points[][], int dp[][]) {
        if (ind == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[ind][i]);
                }
            }
            return maxi;
        }
        if (dp[ind][last] != -1)
            return dp[ind][last];
        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int merit = points[ind][i] + f(ind - 1, last, points);
                maxi = Math.max(maxi, merit);
            }
        }
        return dp[ind][last] = maxi;
    }

    public static int ninjaTraining_M(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f_M(n - 1, 3, points, dp);
    }

    // Tabulation
    public static int ninjaTraining_T(int n, int points[][]) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                }
            }

        }
        return dp[n - 1][3];
    }

    // Space Optimization
    public static int ninjaTraining(int n, int points[][]) {
        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size --> ");
        int n = sc.nextInt();
        int points[][] = new int[n][3];
        System.out.println("Enter the points array --> ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
            System.out.println("Enter the nextRow");
        }
        System.out.println("The Maximum number of Merit Points(Recursion) --> " + ninjaTraining_R(n, points));
        System.out.println("The Maximum number of Merit Points(Memoization) --> " + ninjaTraining_M(n, points));
        System.out.println("The Maximum number of Merit Points(Tabulation) --> " + ninjaTraining_T(n, points));
        System.out.println("The Maximum number of Merit Points(Space Optimization) --> " + ninjaTraining(n, points));
    }
}