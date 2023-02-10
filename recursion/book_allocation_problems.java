/*input 
arr=[12,34,67,90] 
m=2; */


import java.util.Scanner;

public class book_allocation_problems {
    public static boolean possible(int arr[],int n,int m,int mid)
    {
        int sum=0;
        int req=1;
        for(int i=0;i<n;i++)
        {
            if(sum+arr[i]>mid)
            {
                req++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return (req<=m);
    }
    public static int allocation(int arr[], int low, int high, int n, int m) {
        int res=-1;
        if (low > high) {
            return low;
        }
            int mid = low + (high - low) / 2;
            if (possible(arr, n, m, mid) == true) {
                return allocation(arr, low, mid-1,n,m);
                // high = mid - 1;
            } else {
                return allocation(arr, mid+1, high,n,m);
                // low=mid+1;
            }
    }

    public static void main(String Args[])
    {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the number of books -> ");
        int n=scanner.nextInt();
        int arr[]=new int[n];
        int low=0;
        int high=0;
        System.out.println("Enter the no of pages int the books -> ");
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
        System.out.println("Enter the number of students ->");
        int m=scanner.nextInt();
        int value=allocation(arr,low,high,n,m);
        System.out.println("The minimum value -> "+value);
    }
}
