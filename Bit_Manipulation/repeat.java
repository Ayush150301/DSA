import java.util.*;

class repeat {
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array -->");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elemenst of the array -->");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        int xor=0;
        for(int i=0;i<n;i++)
        {
            xor=xor^arr[i];
        }
        int count=0;
        while(xor!=0)
        {
            if((xor&1)!=0)
                break;
            count++;
            xor=xor>>1;
        }

        int xor1=0,xor2=0;
        for(int i=0;i<n;i++)
        {
            if((arr[i]&(1<<count))!=0)
            {
                xor1=xor1^arr[i];
            }
            else{
                xor2=xor2^arr[i];
            }
        }
        System.out.println("The numbers that appears only once -->"+xor1+" "+xor2);
    }    
}
