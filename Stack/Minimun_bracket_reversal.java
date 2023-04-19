import java.util.*;

class Minimun_bracket_reversal {
    static int solve(String str) {
        int ans = 0;
        if (str.length() % 2 == 1)
            return -1;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                st.push(str.charAt(i));
            } else {
                if (!st.empty() && st.peek() == '(')
                    st.pop();
                else {
                    st.push(str.charAt(i));
                }
            }
        }
        int a = 0, b = 0;
        while (!st.empty()) {
            if (st.peek() == '(') {
                a++;
            } else {
                b++;
            }
            st.pop();
        }
        ans = (a + 1) / 2 + (b + 1) / 2;
        return ans;
    }

    static void printStack(String st) {
        System.out.println(st);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string -->");
        String str = sc.next();
        printStack(str);
        System.out.println("The Minimum number of Bracket Reversal -->" + solve(str));
    }

}
