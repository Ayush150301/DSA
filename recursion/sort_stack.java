import java.util.Scanner;
import java.util.Stack;

public class sort_stack {
    public static Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.size()==1) return s;
		int top=s.peek();
		s.pop();
		s=sort(s);
		return correct(top, s);
	}
	public static Stack<Integer> correct(int num,Stack<Integer> s)
	{
	    if(s.isEmpty()|| num>s.peek())
	    {
	        s.push(num);
	        return s;
	    }
	    else
	    {
	        int temp=s.peek();
	        s.pop();
	        s=correct(num,s);
	        s.push(temp);
	        return s;
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
    public static void main(String[] args) {
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
        s=sort(s);
        System.out.println();
        System.out.println("The sorted stack in decending order is =>");
        print_Stack(s);
    }
}
