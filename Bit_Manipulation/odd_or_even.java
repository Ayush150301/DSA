// https://practice.geeksforgeeks.org/problems/odd-or-even3618/1
import java.util.*;
class odd_or_even {
    static String oddEven(int N){
        if((N&1)==1)
        return "odd";
        else
        return "even";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number -->");
        int num=sc.nextInt();
        oddEven(num);
        System.out.println(oddEven(num));
    }
}
