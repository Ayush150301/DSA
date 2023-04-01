import java.util.*;

class redundant_brackets {

    static boolean possible(String str) {
        Stack<Character> st = new Stack<>();
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/') {
                st.push(ch[i]);
            } else {
                if (ch[i] == ')') {
                    boolean check = true;
                    while (st.peek() != '(') {
                        char top=st.peek();
                        if (top == '*' || top == '/' || top == '+' || top== '-') {
                            check = false;
                        }
                        st.pop();
                    }
                    if(check==true)
                    {
                        return true;
                    }
                    st.pop();
                }
            }
        }
        return false;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string -->");
        String str = sc.nextLine();
        System.out.println("Redundant brackets --> " + possible(str));
    }
}
