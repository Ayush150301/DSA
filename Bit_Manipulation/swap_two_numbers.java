// https://practice.geeksforgeeks.org/problems/swap-two-numbers3844/1
import java.util.*;
class swap_two_numbers {
    static List<Integer> get(int a,int b)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        a=a^b;
        b=b^a;
        a=a^b;
        
        arr.add(a);
        arr.add(b);
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of a -->");
        int a=sc.nextInt();
        System.out.println("Enter the value of b -->");
        int b=sc.nextInt();
        List<Integer> arr=get(a,b);
        System.out.println("The swapped array is :"+arr);
    }

}
