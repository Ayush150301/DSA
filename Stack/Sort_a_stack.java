import java.util.*;

class Sort_a_stack {
    static void sortedInsert(Stack<Integer> st,int num)
    {
        if(st.empty()||(!st.empty() && st.peek()<num))
        {
            st.push(num);
            return;
        }
        int n=st.peek();
        st.pop();

        sortedInsert(st, num);
        st.push(n);
    }
    static void sort(Stack<Integer> st)
    {
        if(st.empty())
        {
            return ;
        }
        int num=st.peek();
        st.pop();

        sort(st);
        sortedInsert(st,num);
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
        sort(st);
        System.out.println("The Sorted Stack is -->"+st);
    }    
}
