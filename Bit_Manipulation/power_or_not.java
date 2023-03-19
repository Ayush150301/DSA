// https://leetcode.com/problems/power-of-two/
import java.util.*;
class power_or_not {
    public static boolean isPowerOfTwo(int n) {
        if(n>0)
        {
            if((n&n-1)==0)
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number -->");
        int num=sc.nextInt();
        isPowerOfTwo(num);
        System.out.println(isPowerOfTwo(num));
    }
}
