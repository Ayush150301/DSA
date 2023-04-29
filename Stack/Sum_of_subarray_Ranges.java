import java.util.*;

class Sum_of_subarray_Ranges {
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])) {
                int mid = st.peek();
                st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                answer -= (long) nums[mid] * (i - mid) * (mid - left);
            }
            st.add(i);
        }

        st.clear();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] <= nums[i])) {
                int mid = st.peek();
                st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                answer += (long) nums[mid] * (i - mid) * (mid - left);
            }
            st.add(i);
        }
        return answer;
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
