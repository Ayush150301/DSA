import java.util.Arrays;
import java.util.Scanner;

public class Longest_String_Chain {
    
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, (a,b)->a.length()-b.length()); 
        int n = arr.length;
        int[] dp = new int[n];
        int maxi = 1;
        Arrays.fill(dp , 1);
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(compare(arr[i] , arr[j]) && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            if(dp[i] > maxi)
                maxi = dp[i];
        }
        return maxi;  
    }
    
    boolean compare(String s1 , String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        
        if(l1 != l2+1)
            return false;
        
        int f = 0;
        int s = 0;
        while(f < l1)
        {
            if(s < l2 && s1.charAt(f) == s2.charAt(s)){
                f = f+1;
                s = s+1;
            }
            else
                f = f+1;
        }
        
        if(f == l1 && s == l2)
            return true;
        
        return false;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        String[] words = new String[size];
        System.out.println("Enter the words : ");
        for (int i = 0; i < size; i++) {
            words[i] = sc.next();
        }
        Longest_String_Chain obj = new Longest_String_Chain();
        System.out.println("The longest String chain lenght is -> " + obj.longestStrChain(words));
    }
}
