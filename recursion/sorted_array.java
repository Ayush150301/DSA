import java.util.Scanner;

public class sorted_array {
    static boolean sorted(int arr[],int n)
    {
        if(n==0|| n==1)
        return true;
    
        if(arr[n-1]<arr[n-2])
        return false;
    
        return sorted(arr, n-1);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the element of the array : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        boolean check=sorted(arr,n);
        System.out.println(check);
    }
}
