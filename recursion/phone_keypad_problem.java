import java.util.*;
public class phone_keypad_problem {
    static String mapping[]=new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void help(String digit,StringBuilder output,int index,List<String> ans)
    {
        if(output.length()==digit.length())
        {
            ans.add(output.toString());
            return ;
        }
        int value=digit.charAt(index)-'0';
        for(int i=0;i<mapping[value-1].length();i++)
        {
            output.append(mapping[value-1].charAt(i));
            help(digit,output,index+1,ans);
            output.deleteCharAt(output.length()-1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0)
        {
            return ans;
        }
        StringBuilder output=new StringBuilder();
        help(digits,output,0,ans);
        return ans;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number --> ");
        String str=sc.nextLine();
        List<String> ans=new  ArrayList<>();
        ans=letterCombinations(str);
        System.out.println("the possible combination are --> ");
        System.out.println(ans);
        
    }
}
