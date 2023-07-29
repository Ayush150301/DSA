import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Climbing_Stairs {

    //dp with tabulation
    /*public int climbStairs(int n) {
        if(n==0||n==1)
        return 1;
        int arr[]=new int[n+1];
        arr[0]=arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }*/

    //Dp with memoization
    public int climbStairs(int n,Map<Integer,Integer> map) {
        if(n==0||n==1)
        return 1;
        if(!map.containsKey(n))
        map.put(n,climbStairs(n-1, map)+climbStairs(n-2, map));
        return map.get(n);
    }
    
    // Dp with space optimization
    public int climbStairs(int n) {
        if(n==0||n==1)
        return 1;
        int prev2=1;
        int prev=1;
        for(int i=2;i<=n;i++)
        {
            int temp=prev;
            prev=prev2+prev;
            prev2=temp;
        }
        return prev;
    }
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of steps -> ");
        int n = sc.nextInt();
        Climbing_Stairs obj = new Climbing_Stairs();
        Map<Integer, Integer> dpTable = new HashMap<>();
        System.out.println("The number of ways are -> " + obj.climbStairs(n));
        System.out.println("The number of ways are -> " + obj.climbStairs(n,dpTable));
    }

}
