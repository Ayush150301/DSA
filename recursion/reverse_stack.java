import java.util.*;
public class reverse_stack {
    public static void insert_at_bottom(int x,Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            s.push(x);
        }
        else{
            int temp=s.peek();
            s.pop();
            insert_at_bottom(x, s);
            s.push(temp);
        }
    }
    public static void reverse(Stack<Integer> s)
    {
        if(s.size()>0)
        {
            int x=s.peek();
            s.pop();
            reverse(s);
            insert_at_bottom(x,s);
        }
    }
    public static void print_Stack(Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            return;
        }
        int x=s.peek();
        s.pop();
        System.out.print(x+ " ");

        print_Stack(s);

        s.push(x);
    }
    public static void main(String Args[])
    {
        Scanner scanner=new Scanner(System.in);
        Stack<Integer> s=new Stack<>();
        System.out.println("Enter the number of elements you want to enter => ");
        int n=scanner.nextInt();
        System.out.println("Enter the element =>");
        for(int i=0;i<n;i++)
        {
            int a=scanner.nextInt();
            s.push(a);
        }
        System.out.println("The inserted stack =>");
        print_Stack(s);

        //sort the stack
        reverse(s);
        System.out.println();
        System.out.println("The reverse stack is =>");
        print_Stack(s);
    }
}
