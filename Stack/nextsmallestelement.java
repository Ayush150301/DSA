import java.util.*;

class nextsmallestelement {
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public int[] solve(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (st.peek() >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.push(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array -->");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array -->");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        nextsmallestelement m = new nextsmallestelement();
        int ans[] = new int[n];
        ans = m.solve(arr, n);
        System.out.println("The next smallest element array is -->");
        m.printArray(ans);
    }

}