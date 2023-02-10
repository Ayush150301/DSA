import java.util.*;


public class peak_in_mountain {
    public static int peak(int arr[],int low,int high)
    {
        int n=arr.length;
        int mid=low+(high-low)/2;
        if(mid==0)
        {
            return arr[0]>=arr[1]?0:1;
        }
        if(mid==n-1)
        {
            return arr[n-1]>=arr[n-2]?n-1:n-2;
        }
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
        return mid;
        else if(arr[mid]<arr[mid-1])
        {
            return peak(arr, low, mid-1);
        }
        else
        {
            return peak(arr, mid+1, high);
        }
    }
    public static void main(String Args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of the array -->");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements of the array -->");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int index=peak(arr,0,n-1);
        System.out.println("The peak of the array -> "+index);
    }   
}
