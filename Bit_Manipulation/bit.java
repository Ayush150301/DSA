// https://practice.geeksforgeeks.org/problems/bit-manipulation-1666686020/1
import java.util.*;
class bit{
    static void bitManipulation(int num, int i) {
        long mask=1<<(i-1);
        
        long get=(num&mask)>>(i-1);
        long set=num|mask;
        long clear=(num & (~mask));
        
        System.out.print(get+" "+set+" "+clear);
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number -->");
        int num=sc.nextInt();
        System.out.println("Enter the position --> ");
        int i=sc.nextInt();
        bitManipulation(num,i);
    }
}