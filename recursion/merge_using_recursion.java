import java.util.Scanner;
/*There are two ways to solve this 
 * 1. Creating new array and copying the values 
 * 2. Using the high and low indexes taking the mid and so on.
 */

/*First Solution  by creating new arrays and copying the values of two different arrays */
// public class merge_using_recursion {
//     public static void merge(int arr[],int low,int high)
//     {
//         int mid=low+(high-low)/2;
//         int len1=mid-low+1;
//         int len2=high-mid;
//         int arr1[]=new int[len1];
//         int arr2[]=new int[len2];

//         int k=low;
//         for(int i=0;i<len1;i++)
//         {
//             arr1[i]=arr[k++];  
//         }

//         k=mid+1;
//         for(int i=0;i<len2;i++)
//         {
//             arr2[i]=arr[k++];
//         }

//         //merge two arrays 
//         int index1=0;
//         int index2=0;
//         k=low;
//         while(index1<len1 && index2<len2)
//         {
//             if(arr1[index1]<arr2[index2])
//             {
//                 arr[k++]=arr1[index1++];
//             }
//             else
//             {
//                 arr[k++]=arr2[index2++];
//             }
//         }

//         while(index1<len1)
//         {
//             arr[k++]=arr1[index1++];
//         }
//         while(index2<len2)
//         {
//             arr[k++]=arr2[index2++];
//         }

//     } 

//     public static void merge_sort(int arr[], int low, int high) {
//         // Base case
//         if (low >= high) {
//             return;
//         }
//         int mid = low + (high - low) / 2;

//         // solving the left part -->
//         merge_sort(arr, low, mid);

//         // solving the right part -->
//         merge_sort(arr, mid + 1, high);

//         // merging both the parts of the array
//         merge(arr, low, high);
//     }

//     public static void printArray(int arr[], int n) {
//         for (int i = 0; i < n; i++) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String Args[]) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the size of the Array  ==>>");
//         int n = scanner.nextInt();
//         int arr[] = new int[n];
//         System.out.println("enter the elements of the Array  ==>>");
//         for (int i = 0; i < n; i++) {
//             arr[i] = scanner.nextInt();
//         }
//         int low = 0;
//         int high = n - 1;
//         System.out.println("The Inserted Array is ==>>");
//         printArray(arr, n);
//         merge_sort(arr, low, high);
//         System.out.println("The Sorted Array is ==>>");
//         printArray(arr, n);


//     }
// }


// Second Solution using the index of the original array
public class merge_using_recursion {
        public static void merge(int arr[],int low,int high)
        {
            int mid=low+(high-low)/2;
            int len1=mid-low+1;
            int len2=high-mid;
            int arr1[]=new int[len1];
            int arr2[]=new int[len2];
    
            int k=low;
            for(int i=0;i<len1;i++)
            {
                arr1[i]=arr[k++];  
            }
    
            k=mid+1;
            for(int i=0;i<len2;i++)
            {
                arr2[i]=arr[k++];
            }
    
            //merge two arrays 
            int index1=0;
            int index2=0;
            k=low;
            while(index1<len1 && index2<len2)
            {
                if(arr1[index1]<arr2[index2])
                {
                    arr[k++]=arr1[index1++];
                }
                else
                {
                    arr[k++]=arr2[index2++];
                }
            }
    
            while(index1<len1)
            {
                arr[k++]=arr1[index1++];
            }
            while(index2<len2)
            {
                arr[k++]=arr2[index2++];
            }
    
        } 
    
        public static void merge_sort(int arr[], int low, int high) {
            // Base case
            if (low >= high) {
                return;
            }
            int mid = low + (high - low) / 2;
    
            // solving the left part -->
            merge_sort(arr, low, mid);
    
            // solving the right part -->
            merge_sort(arr, mid + 1, high);
    
            // merging both the parts of the array
            merge(arr, low, high);
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
            System.out.println("The Inserted Array is ==>>");
            printArray(arr, n);
            merge_sort(arr, low, high);
            System.out.println("The Sorted Array is ==>>");
            printArray(arr, n);
    
    
        }
    }
    
    



