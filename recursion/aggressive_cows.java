/*input
arr =[1,2,4,8,9] 
k=3(cows) */

import java.util.*;

public class aggressive_cows {
    public static boolean placecows(int stalls[], int n, int cows, int dist) {
        int ord = stalls[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - ord >= dist) {
                count++;
                ord = stalls[i];
            }
            if (count == cows)
                return true;
        }
        return false;
    }

    public static int cow(int arr[], int low, int high, int k, int res) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (placecows(arr, arr.length, k, mid) == true) {
            return cow(arr, mid + 1, high, k, res);
        } else {
            return cow(arr, low, mid - 1, k, res);
        }

        // return -1;
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
        Arrays.sort(arr);
        System.out.println("enter the number of cows ->");
        int k = scanner.nextInt();
        int high = arr[n - 1] = arr[0];
        int low = 1;
        int dist = cow(arr, low, high, k, 0);
        System.out.println("The minimum distance between the stalls  -> " + dist);
    }

}
