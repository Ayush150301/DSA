import java.util.*;
class recursion{
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number :-");
        int n=sc.nextInt();
        // int r=factorial(n);
        // int r=power(n);
        int r=fib(n);
        System.out.println("the answer is "+r);
    }
    public static int factorial(int n)
    {
        if(n==0)
        return 1;

        return n*factorial(n-1);
    }
    public static int power(int n)
    {
        if(n==0)
        return 1;

        return 2*power(n-1);
    }
    public static int fib(int n)
    {
        if(n==0)
        return 0;

        if(n==1)
        return 1;
        
        return fib(n-2)+fib(n-1);
    }
}