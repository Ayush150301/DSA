import java.util.*;

public class binary_search {
    static boolean search(int arr[],int low,int high,int key)
    {
        if(low>high)
        return false;
        int mid=low+(high-low)/2;
        if(arr[mid]==key)
        return true;
        if(arr[mid]<key)
        {
            return search(arr, mid+1, high, key);
        }
        else
        {
            return search(arr,low,mid-1,key);
        }
    }
    public static void main(String Args[])
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int n=scanner.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the element of the array : ");
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        System.out.println("enter the key :-");
        int key=scanner.nextInt();
        int low=0;
        int high=arr.length-1;
        boolean check=search(arr,low,high,key);
        System.out.println(check);
    }
}
