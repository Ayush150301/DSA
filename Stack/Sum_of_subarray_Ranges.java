import java.util.*;
import java.util.function.BiFunction;

class Sum_of_subarray_Ranges {
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public long pushToStack(Stack<Integer> stack, int[] nums, int i, BiFunction<Integer, Integer, Boolean> compare) {
        long sum = 0;
        while (!stack.isEmpty() && (i == nums.length || compare.apply(nums[stack.peek()] ,nums[i]))) {
            int top = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();// calcuating the left and the right greater or lesser elements from the position.
            sum += (top - left) * (i - top) * (long) nums[top];
        }
        stack.push(i);
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        // decreasing stack => finds the previous greater an next greater elements

        // increasing stack => finds previous lesser and next lesser elements

        Stack<Integer> dec = new Stack<>();
        Stack<Integer> inc = new Stack<>();
        long ans = 0;

        for (int i = 0; i <=nums.length; i++) {
            ans += pushToStack(dec, nums, i, (a, b) -> a < b) - pushToStack(inc, nums, i, (a, b) -> a > b);
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array ==> ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Sum_of_subarray_Ranges s = new Sum_of_subarray_Ranges();
        System.out.println("Inputted array ==> ");
        s.printArray(a);
        System.out.println("The sum of subarray ranges ==> " + s.subArrayRanges(a));
    }
}
