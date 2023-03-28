import java.util.*;

class XOR_of_L_to_R {
    public static int XOR(int n)
    {
        if(n%4==0) return n;
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        else return 0;
    }
    public static int findXOR(int l, int r) {
        return XOR(l-1)^XOR(r);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the starting number -->");
        int l=sc.nextInt();
        System.out.println("enter the ending number -->");
        int r=sc.nextInt();
        System.out.println("XOR of "+l+" to "+r+" is --> "+findXOR(l,r));
    }
}
