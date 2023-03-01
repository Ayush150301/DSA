import java.util.*;
public class subset_2 {
    public static void solve(int[] nums,List<List<Integer>> ans,int ind,List<Integer> list)
    {
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            solve(nums,ans,i+1,list);
            list.remove(list.size()-1);
        }
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
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        solve(arr,ans,0,new ArrayList<>());
        System.out.println("The sum of the subsets ->"+ans);
    }
}
