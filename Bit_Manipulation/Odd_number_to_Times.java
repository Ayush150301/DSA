import java.util.*;

class Odd_number_to_Times {
    public static int getOddOccurrence(int[] arr, int n) {
        int xor=0;
        for(int i=0;i<n;i++)
        {
            xor=xor^arr[i];
        }
        return xor;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements you want to enter in the array --> ");
        int n=sc.nextInt();

        int arr[]=new int[n];
        System.out.println("Enter the elements of the array -->");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("The odd occurrence of the array is -->"+getOddOccurrence(arr,n));
    }
}
