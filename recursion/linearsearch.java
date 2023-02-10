import java.util.Scanner;

public class linearsearch {
    static boolean search(int arr[],int n,int key)
    {
        if(n==0)
        return false;
    
        if(arr[n-1]==key)
        return true;
    
        return search(arr,n-1,key);
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
        System.out.println("enter the key :-");
        int key=sc.nextInt();
        boolean check=search(arr,n,key);
        System.out.println(check);
    }
}
