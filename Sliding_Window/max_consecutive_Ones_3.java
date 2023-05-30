import java.util.*;

public class max_consecutive_Ones_3 {
    void display(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        int zero=0;
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]==0)
            zero++;
            while(zero>k)
            {
                if(nums[i]==0)
                zero--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
        
    }
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(("Enter the size of the array --> "));
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println(("Enter the array elements --> "));
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k --> ");
        int k = sc.nextInt();
        max_consecutive_Ones_3 m = new max_consecutive_Ones_3();
        int ans = m.longestOnes(arr, k);
        System.out.println(("The longest consecutive ones of size " + k + " are " + ans));
    }
}
