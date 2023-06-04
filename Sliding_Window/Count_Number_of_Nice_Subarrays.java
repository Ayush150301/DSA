import java.util.*;

class Count_Number_of_Nice_Subarrays {
    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        count = 0;
        int n = nums.length;
        int odd = 0;
        int sum = 0;
        int len = 0;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                odd++;
                ans = 0;
            }
            while (odd == k) {
                ans++;
                if (nums[j] % 2 != 0) {
                    odd--;
                }
                j++;
            }
            count += ans;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array --> ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of odd numbers  --> ");
        int k = sc.nextInt();
        Count_Number_of_Nice_Subarrays b = new Count_Number_of_Nice_Subarrays();
        System.out.println("The inputted array --> ");
        b.display(arr);
        int count = b.numberOfSubarrays(arr, k);
        System.out.println("Number of subarrays with " + k + " odd numbers are " + count);
    }
}
