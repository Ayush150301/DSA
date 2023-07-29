import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class House_Robber_II {
    //Space Optimization
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return valueInHouse[0];
        }
        int arr1[] = new int[n - 1];
        int arr2[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = valueInHouse[i + 1];
            arr2[i] = valueInHouse[i];
        }
        long one = solveUtil(arr1);
        long oneee = solveUtil(arr2);
        return Math.max(one, oneee);
    }

    public static long solveUtil(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        long prev = arr[0];
        long prev2 = 0;
        for (int i = 1; i < n; i++) {
            long pick = arr[i];
            if (i > 1)
                pick += prev2;
            long nonPick = 0 + prev;
            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n  --> ");
        int n = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the elements of the array ->");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("The Maximum Amount of Money -->(Space Optimization) " + houseRobber(nums));
    }

}
