import java.util.Arrays;
import java.util.Scanner;

public class Minimal_Cost {
    public static int minimizeCost(int n, int k, int[] height) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return mincost(n - 1, k, height, dp);
    }

    public static int mincost(int i, int k, int[] height, int[] dp) {
        if (i == 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++)
        {
            if(i-j>=0)
            {
                int jump=mincost(i-j, k, height, dp)+Math.abs(height[i]-height[i-j]);
                min=Math.min(min, jump);
            }
        }
        return dp[i]=min;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stones --> ");
        int n = sc.nextInt();
        System.out.println("Enter the value of k --> ");
        int k = sc.nextInt();
        int height[] = new int[n];
        System.out.println("Enter the height of the stone --> ");
        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
        }
        int mincost = minimizeCost(n, k, height);
        System.out.println("The Minimum Cost --> " + mincost);
    }

}
