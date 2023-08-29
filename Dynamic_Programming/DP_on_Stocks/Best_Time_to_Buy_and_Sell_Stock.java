import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock {
    // Recursion
    public int maxProfit_R(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        return getMaxProfit(prices, 0, Integer.MAX_VALUE, 0);
    }

    public int getMaxProfit(int[] prices, int index, int minStockPrice, int maxDiff) {
        if(prices.length == index) {
            return maxDiff;
        }
         int earn =  prices[index] - minStockPrice;
         maxDiff = Math.max(earn, maxDiff);
         minStockPrice = Math.min(minStockPrice, prices[index]);
        return getMaxProfit(prices, ++index, minStockPrice, maxDiff);
    }
    // Tabulation
    public int maxProfit_T(int[] prices) {
        int maxProfit=0;
        int mini=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            int curProfit=prices[i]-mini;
            maxProfit=Math.max(maxProfit, curProfit);
            mini=Math.min(mini, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array : "); 
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        Best_Time_to_Buy_and_Sell_Stock a = new Best_Time_to_Buy_and_Sell_Stock();
        System.out.println("Maximum Profit Recursion: " + a.maxProfit_R(arr));
        System.out.println("Maximum Profit Tabulation:" + a.maxProfit_T(arr));

    }
}
