import java.util.*;

public class first_last_occurrence {
    // first occurence of the key
    static int first(int arr[], int low, int high, int key) {
        // int index=0;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid - 1] < key) && arr[mid] == key) {
                // index=mid;
                return mid;
            } else if (arr[mid] < key) {
                return first(arr, mid + 1, high, key);
            } else {
                return first(arr, low, mid - 1, key);
            }
        }
        return -1;
    }

    // last occurrence of the key
    static int last(int arr[], int low, int high, int key) {
        // int index=0;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == arr.length - 1 || arr[mid + 1] > key) && arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return last(arr, low, mid - 1, key);
            } else {
                return last(arr, mid + 1, high, key);
            }
        }
        return -1;
    }

    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the size of the array -->");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements of the array -->");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("enter the key you want to find -->");
        int key = scanner.nextInt();
        int f = first(arr, 0, n - 1, key);
        int l = last(arr, 0, n - 1, key);
        System.out.println("the first occurrencce of the key = " + f);
        System.out.println("the last occurrencce of the key = " + l);
    }
}
