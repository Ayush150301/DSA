import java .util.*;
public class generate_binary {
    public static void generate(ArrayList<String> res,int n,String str)
    {
        if(str.length()==n)
        {
            res.add(str);
            return ;
        }
        generate(res, n, str+'0');
        if(str.length()>0 && str.charAt(str.length()-1)!='1')
        {
            generate(res, n, str+'1');
        }
        if(str.length()==0)
        {
            generate(res, n, str+"1");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the number :-");
        int n=scanner.nextInt();
        ArrayList<String> res=new ArrayList<>();
        generate(res,n,"");
        System.out.println("The Generated String are->");
        for(String s:res)
        {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}

