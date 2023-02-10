import java.util.Scanner;

public class search_rotated_array {
    public static int search(int arr[], int low, int high, int n, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= key && arr[mid] >= key) {
                    return search(arr, low, mid - 1, n, key);
                } else {
                    return search(arr, mid + 1, high, n, key);
                }
            } else {
                if (arr[mid] <= key && arr[high] >= key) {
                    return search(arr, mid + 1, high, n, key);
                } else {
                    return search(arr, low, mid - 1, n, key);
                }
            }
        }
        return -1;
    }

    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array -> ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array -> ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the element to be search ->");
        int key = scanner.nextInt();
        int position = search(arr, 0, n - 1, n, key);
        System.out.println("Position of the element is -> " + position);
    }
}
