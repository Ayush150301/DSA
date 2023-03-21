// https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1
import java.util.*;
class rightmost_unset_bit {
    static int setBit(int N){
        if((N&N+1)!=0)
        {
            return N|N+1;
        }
        else
        {
            return N;
        }
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number -->");
        int n=sc.nextInt();
        int r=setBit(n);
        System.out.println("The rightmost unset bit is "+r);
    }
}
