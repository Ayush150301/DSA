import java.util.*;
public class expression_add_operator {
    public static List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<>();
        if(num==null || num.length()==0)
        return res;
        help(res,"",num,target,0,0,0);
        return res;
    }
    public static void help(List<String> res,String path,String num,int target,int pos,long value,long multed)
    {
        if(pos==num.length())
        {
            if(target==value)
                res.add(path);
            return ;
        }
        for(int i=pos;i<num.length();i++)
        {
            if(i!=pos && num.charAt(pos)=='0') break;
            long cur=Long.parseLong(num.substring(pos,i+1));
            if(pos==0)
            {
                help(res,path+cur,num,target,i+1,cur,cur);
            }
            else
            {
                help(res,path+ "+" +cur,num,target,i+1,value+cur,cur);
                help(res,path+ "-" +cur,num,target,i+1,value-cur,-cur);
                help(res,path+ "*" +cur,num,target,i+1,value-multed+multed*cur,multed*cur);
            }
        }
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String -->");
        String str=sc.nextLine();
        System.out.println("Enter the target -->");
        int target=sc.nextInt();
        List<String> result=new ArrayList<>();
        result=addOperators(str,target);
        System.out.println("All the possible -->"+result);
    }
}
