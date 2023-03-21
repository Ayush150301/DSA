import java.util.*;
class Divide {
    public static int divide(int dividend, int divisor) {
        long n=dividend,m=divisor;
        int sign=n<0^m<0?-1:1;
        n=Math.abs(n);
        m=Math.abs(m);
        long q=0;
        long t=0;
        for(long i=31;i>=0;i--)
        {
            if(t+(m<<i)<=n)
            {
                t+=(m<<i);
                q=q|(1L<<i);
            }
        }
        if(sign<0) q=-q;
        q=(q>=Integer.MAX_VALUE||q<Integer.MIN_VALUE)?Integer.MAX_VALUE:q;
        return (int)q;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dividend --> ");
        int n=sc.nextInt();
        System.out.println("Enter the divisor --> ");
        int m=sc.nextInt();
        System.out.println("The quotient of the two numbers are -->"+divide(n, m));
    } 
}
