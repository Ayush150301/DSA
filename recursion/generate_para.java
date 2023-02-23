import java .util.*;
public class generate_para {
    public static  void generate(ArrayList<String> res,int op,int cl,String str)
    {
        if(op==0 && cl==0)
        {
            res.add(str);
            return;
        }
        if(op!=0)
        {
            generate(res, op-1, cl, str+'(');
        }
        if(cl>op)
        {
            generate(res, op, cl-1, str+')');
        }
    }
    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the string -->");
        int n=sc.nextInt();
        ArrayList<String>  res=new ArrayList<>();
        generate(res,n,n,"");
        System.out.println("The possible string -->");
        for(String s:res)
        {
            System.out.print(s+" ");
        }
    }   

}
