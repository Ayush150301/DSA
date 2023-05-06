import java.util.*;

class remove_k_digit {
    public void print(String str) {
        System.out.println(str);
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if (k == num.length())
            return "0";
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        // for corner cases like 1111
        while (k > 0) {
            st.pop();
            k--;
        }
        // contructing number from stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string =>");
        String str = sc.nextLine();
        System.out.println("Enter the value of k =>");
        int k = sc.nextInt();
        remove_k_digit r = new remove_k_digit();
        System.out.println("Inputted String ==>");
        r.print(str);
        System.out.println("The smallest number after removing ==>");
        r.print(r.removeKdigits(str, k));
    }
}
