import java.util.*;

public class palindrome_partition {
    public static List<List<String>> partiton(String s)
    {
        List<List<String>> res=new ArrayList<>();
        List<String>  output=new ArrayList<>();
        help(s,0,output,res);
        return res;
    }  
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String --> ");
        String s=sc.nextLine();
        List<List<String>> res=new ArrayList<>();
        res=partiton(s);
        System.out.println("The possible combination -->");
        System.out.println(res);

    }    

    public static void help(String s,int ind,List<String>output,List<List<String>> res)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList<>(output));
            return ;
        }

        for(int i=ind;i<s.length();i++)
        {  
            if(ispalindrome(s,ind,i))
            {
                output.add(s.substring(ind,i+1));
                help(s,i+1,output,res);
                output.remove(output.size()-1);
            }
        }
    }

    public static boolean ispalindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }
}
