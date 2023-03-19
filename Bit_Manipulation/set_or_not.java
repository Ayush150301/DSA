// https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
import java.util.*;
class set_or_not {
    static boolean checkKthBit(int n, int k)
    {
        int mask=1<<k;
        if((n&mask)==0)
        return false;
        else
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number -->");
        int num=sc.nextInt();
        System.out.println("Enter the position --> ");
        int i=sc.nextInt();
        checkKthBit(num,i);
        System.out.println(checkKthBit(num, i));
    }
}
