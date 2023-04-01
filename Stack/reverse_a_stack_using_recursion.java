import java.util.*;
import java.util.Stack;
class reverse_a_stack_using_recursion {
    static void insert_At_Bottom(Stack<Integer> st,int num)
    {
        if(st.empty())
        {
            st.push(num);
            return;
        }
        int e=st.peek();
        st.pop();

        insert_At_Bottom(st, num);
        st.push(e);
    }
    static void reverse(Stack<Integer> st)
    {
        if(st.empty())
        {
            return;
        }
        int num=st.peek();
        st.pop();

        reverse(st);
        insert_At_Bottom(st,num);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements you want to enter -->");
        int n=sc.nextInt();
        Stack<Integer> st=new Stack<>();
        System.out.println("Enter the elements of the stack -->");
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            st.push(a);
        }
        reverse(st);
        System.out.println("The reversed Stack is -->"+st);
    }
    
}
