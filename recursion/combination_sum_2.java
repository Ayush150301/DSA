import java.util.*;

public class combination_sum_2{
    public static void findcomb(int ind,int arr[],int target,List<List<Integer>> ans,ArrayList<Integer> ds)
    {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findcomb(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
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
        Arrays.sort(arr);
        findcomb(0,arr,target,res,new ArrayList<>());
        System.out.println("The combination are ->");
        System.out.println(res);
    }
} 
