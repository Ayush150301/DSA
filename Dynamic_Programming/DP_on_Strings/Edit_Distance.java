import java.util.Arrays;
import java.util.Scanner;

public class Edit_Distance {
    public int minDistance_R(String word1, String word2) {
        return f(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    public int f(int i, int j, String word1, String word2) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (word1.charAt(i) == word2.charAt(j))
            return 0 + f(i - 1, j - 1, word1, word2);

        else
            return 1 + Math.min(f(i - 1, j - 1, word1, word2),
                    Math.min(f(i, j - 1, word1, word2), f(i - 1, j, word1, word2)));
    }

    public int minDistance_M(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }

    private int f(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j))
            return 0 + f(i - 1, j - 1, word1, word2);

        else
            return dp[i][j] = 1 + Math.min(f(i - 1, j - 1, word1, word2),
                    Math.min(f(i, j - 1, word1, word2), f(i - 1, j, word1, word2)));

    }

    public int minDistance_T(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++)
            dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[j] = 0 + prev[j - 1];

                else
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
            }
            prev = (int[]) (cur.clone());
        }
        return prev[m];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string 1 : ");
        String word1 = sc.next();
        System.out.println("\n");
        System.out.print("Enter the string 2 : ");
        String word2 = sc.next();
        System.out.println("\n");
        System.out.println("The minimum distance between two strings is(Recusrion) "
                + new Edit_Distance().minDistance_R(word1, word2));
        System.out.println("The minimum distance between two strings is(Memoization) "
                + new Edit_Distance().minDistance_M(word1, word2));
        System.out.println("The minimum distance between two strings is(Tabualtion) "
                + new Edit_Distance().minDistance_T(word1, word2));
        System.out.println("The minimum distance between two strings is(Space Optimization) "
                + new Edit_Distance().minDistance(word1, word2));
    }

}
