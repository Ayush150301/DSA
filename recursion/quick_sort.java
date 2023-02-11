import java.util.Scanner;

public class quick_sort {
    public static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i=(low-1);
        for(int j=low;j<=high-1;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        int t=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=t;
        return i+1;
    }

    public static void quick(int arr[], int low, int high) {
        // base case
        if (low >= high)
            return;

        // partition karenge
        int p = partition(arr, low, high);
        // left part sort karo
        quick(arr, low, p - 1);
        // right part sort karo
        quick(arr, p + 1, high);
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the Array  ==>>");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements of the Array  ==>>");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int low = 0;
        int high = n - 1;
        System.out.println("The Array is ==>>");
        printArray(arr, n);
        quick(arr, low, high);
        System.out.println("The Sorted Array is ==>>");
        printArray(arr, n);

    }
}
