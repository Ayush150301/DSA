import java.util.Arrays;
import java.util.Scanner;

public class Longest_Bitonic_Sequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        // Increasing elements of the array
        for (int i = 0; i <= n - 1; i++) {
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prev_index]);
                }
            }
        }

        //Increasing the elements of the array from the back side
        // reverse the direction of nested loops
        for (int i = n - 1; i >= 0; i--) {
            for (int prev_index = n - 1; prev_index > i; prev_index--) {

                if (arr[prev_index] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prev_index]);
                }
            }
        }

        int maxi = -1;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The Longest Bitonic Sequence : " + longestBitonicSequence(arr, size));
    }
}