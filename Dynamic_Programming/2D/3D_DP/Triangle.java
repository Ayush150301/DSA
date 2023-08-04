import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle {
    // Recursion
    public int minimumTotal_R(List<List<Integer>> triangle) {
        return f(triangle, 0, 0);
    }

    private int f(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + f(triangle, i + 1, j);
        int diagonal = triangle.get(i).get(j) + f(triangle, i + 1, j + 1);
        return Math.min(down, diagonal);
    }

    // Memoization
    public int minimumTotal_M(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size() - 1][triangle.get(triangle.size() - 1).size()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f(triangle, 0, 0, dp);
    }

    private int f(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = triangle.get(i).get(j) + f(triangle, i + 1, j, dp);
        int diagonal = triangle.get(i).get(j) + f(triangle, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Tabulation
    public int minimumTotal_T(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][triangle.get(n - 1).size()];
        for (int j = 0; j < n; j++)
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    // Space Optimization
    public int minimumTotal(List<List<Integer>> triangle) {
        int front[] = new int[triangle.size()];
        int cur[] = new int[triangle.size()];
        for (int j = 0; j < triangle.size(); j++) {
            front[j] = triangle.get(triangle.size() - 1).get(j); // last row of the list will be the base case
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            front = cur;
        }
        return front[0];
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows -->");
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> l1 = new ArrayList<>();
            System.out.println("Enter the elements of list " + (i));
            for (int j = 1; j <= i; j++) {
                l1.add(sc.nextInt());
            }
            list.add(l1);
        }
        Triangle obj = new Triangle();
        System.out.println("The minimum sum path from top to bottom (Recursion) : " + obj.minimumTotal_R(list));
        System.out.println("The minimum sum path from top to bottom (Memoization) : " + obj.minimumTotal_M(list));
        System.out.println("The minimum sum path from top to bottom (Tabulation) : " + obj.minimumTotal_T(list));
        System.out.println("The minimum sum path from top to bottom (Space Optimization) : " + obj.minimumTotal(list));

    }
}
