import java.util.*;
class count_total_set_bits{
    public static int countSetBits(int n){
        if(n==0)
        return 0;
        int temp=n;
        int x=0;
        while(temp>1)
        {
            temp=temp>>1;
            x++;
        }
        
        return (int)Math.pow(2,x-1)*x+n-(int)Math.pow(2,x)+1+countSetBits(n-(int)Math.pow(2,x));   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number -->");
        int n=sc.nextInt();
        System.out.println("The number of set bits are "+countSetBits(n));
    }

}