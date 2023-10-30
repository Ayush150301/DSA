import java.util.Scanner;

public class Count_Square_Submatrices_with_All_Ones {
    public int countSquares(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++)
            dp[0][j] = arr[0][j];
        for (int i = 0; i < n; i++)
            dp[i][0] = arr[i][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        System.out.print("Enter the value of m : ");
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        System.out.println("Enter the elements of the arrays : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Count_Square_Submatrices_with_All_Ones obj=new Count_Square_Submatrices_with_All_Ones();
        System.out.println("The number of square sub-matrices with all ones is " + obj.countSquares(matrix));
    }
}
