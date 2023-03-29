import java.util.*;

class valid_paranthesis {
    public static boolean check(String str)
    {
        Stack<Character> st=new Stack<>();
        for(char it:str.toCharArray())
        {
            if(it=='('||it=='{'||it=='[')
            {
                st.push(it);
            }
            else{
                if(st.empty()) return false;
                char ch=st.pop();
                if((it==')' && ch=='(')||(it=='}' && ch=='{')||(it==']' && ch=='[')) continue;
                else return false;
            }
        }
        return st.empty();
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string -->");
        String str = sc.nextLine();
        System.out.println("Is valid paranthesis --> "+check(str));
    }
}
