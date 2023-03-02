import java.util.*;
public class combination_3 {
    public static void help(int i,int k,int sum,int n,List<Integer> sub,List<List<Integer>> ans)
    {
        if(sum>n)
        return ;

        if(k==0)
        {
            if(sum==n)
            {
                ans.add(new ArrayList<>(sub));
                return ;
            }
            return ;
        }

        if(i==10)
        {
            return ;
        }

        sub.add(i);
        help(i+1, k-1, sum+i, n, sub, ans);
        sub.remove(sub.size()-1);
        help(i+1, k, sum, n, sub, ans);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array ->");
        int k=sc.nextInt();
        System.out.println("Enter the target ->");
        int n=sc.nextInt();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        help(1,k,0,n,sub,ans);
        System.out.println("The combination are ->");
        System.out.println(ans);
    }    
}
