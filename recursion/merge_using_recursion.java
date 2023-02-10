import java.util.Scanner;
/*There are two ways to solve this 
 * 1. creating new array and copying the values 
 * 2. using the high and low indexes taking the mid and so on.
 */
   
 /*First Solution */
public class merge_using_recursion{
    public static void merge(int arr[],int low,int high)
    {

    }
    public static void merge_sort(int arr[],int low,int high)
    {
        // Base case
        if(low>high)
        {
            return ;
        }
        int mid=low+(high-low)/2;

        // solving the left part -->
        merge_sort(arr, low, mid);

        // solving th right part -->
        merge_sort(arr, mid+1, high);

        // merging both the parts of the array
        merge(arr,low,high);
    }
    public static void printArray(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String Args[])
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the Array  ==>>");
        int n=scanner.nextInt();
        int arr[]=new int[n];
        System.out.println("enter the elements of th array  ==>>");
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        int low=0;
        int high=n-1;
        System.out.println("The inserted array is ==>>");
        printArray(arr, n);
        System.out.println("The sorted array is ==>>");
        merge_sort(arr,low,high);
        
    }
}