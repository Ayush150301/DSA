import java.util.Scanner;

public class sqaure_root {
    public static int solve(int n, int low, int high) {
        // int ans = 0;
        if (low > high) {
            return high;
        }
            int mid = low + (high - low) / 2;
            if (mid * mid == n) {
                // ans = mid; // how record this answer in recursion?
                return mid;
            } else if (mid * mid > n) {
                return solve(n, low, mid - 1);
            } else {
                // ans=mid;
                return solve(n, mid+1, high);
            }
        }
    

    public static void main(String Args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number -> ");
        int n = scanner.nextInt();
        int ans = solve(n, 1, n);
        System.out.println("The Square root of the number n -> " + ans);

    }
}
