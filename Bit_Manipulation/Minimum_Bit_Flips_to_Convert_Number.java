import java.util.*;

class Minimum_Bit_Flips_to_Convert_Number {
    public static int minBitFlips(int start, int goal) {
        return Integer.bitCount(start^goal);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the start --> " );
        int start=sc.nextInt();
        System.out.println("Enter the goal --> " );
        int goal=sc.nextInt();

        System.out.println("The number bit that need to flip --> "+minBitFlips(start, goal) );   
    }
}
