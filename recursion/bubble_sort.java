import java.util.*;

public class bubble_sort {
    static void sort_array(int arr[],int n)
    {
        if(n==0||n==1)
        {
            return ;
        }
        int count=0;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]>arr[i+1])
            {
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                count++;
            }
        }
        if(count==0)
        return ;
        sort_array(arr, n-1);
    }
    public static void main(String Args[])
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the array ->");
        int n=scanner.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array =>");
        for(int i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        sort_array(arr,n);
        System.out.println("The sorted array ==>");
        System.out.println(Arrays.toString(arr));
    }
}
