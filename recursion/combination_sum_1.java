import java.util.*;

public class combination_sum_1{
    public static void findcomb(int index,int candidates[],int target,List<List<Integer>> res,ArrayList<Integer> list)
    {
        if(index==candidates.length)
        {
            if(target==0)
            {
                res.add(new ArrayList<>(list));
            }
            return ;
        }
        if(candidates[index]<=target)
        {
            list.add(candidates[index]);
            findcomb(index,candidates,target-candidates[index],res,list);
            list.remove(list.size()-1);
        }
        findcomb(index+1,candidates,target,res,list);
    }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> res=new ArrayList<>();
    //     findcomb(0,candidates,target,res,new ArrayList<>());
    //     return res;
    // }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ->");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array ->");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the target ->");
        int target=sc.nextInt();
        List<List<Integer>> res=new ArrayList<>();
        findcomb(0,arr,target,res,new ArrayList<>());
        System.out.println("The combination are ->");
        System.out.println(res);
    }
}