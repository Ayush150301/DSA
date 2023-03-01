import java.util.*;
public class subset_1 {
    public static void solve(int arr[],int len,int ind,int sum,ArrayList<Integer> ans)
    {   if(ind==len)
        {
            ans.add(sum);
            return ;
        }

        solve(arr, len, ind+1, sum+arr[ind], ans);
        solve(arr, len, ind+1, sum, ans);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the arrays ->");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the arrays ->");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> ans=new ArrayList<>();
        solve(arr,n,0,0,ans);
        Collections.sort(ans);
        System.out.println("The sum of the subsets ->"+ans);
    }
    
}
