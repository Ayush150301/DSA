import java.util.*;

class Sum_of_maxi_and_mini {
    int solve(int arr[], int k) {
        Deque<Integer> maxi = new ArrayDeque<>();
        Deque<Integer> mini = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!maxi.isEmpty() && arr[maxi.getLast()] <= arr[i]) {
                maxi.removeLast();
            }
            while (!mini.isEmpty() && arr[mini.getLast()] >= arr[i]) {
                mini.removeLast();
            }
            maxi.add(i);
            mini.add(i);

        }
        int ans = 0;
        ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];
        for (int i = k; i < arr.length; i++) {
            // next window

            //removal
            while (!maxi.isEmpty() && i - maxi.peekFirst() >= k) {
                maxi.removeFirst();
            }
            while (!mini.isEmpty() && i - mini.peekFirst() >= k) {
                mini.removeFirst();
            }

            // addition 

            while (!maxi.isEmpty() && arr[maxi.getLast()] <= arr[i]) {
                maxi.removeLast();
            }
            while (!mini.isEmpty() && arr[mini.getLast()] >= arr[i]) {
                mini.removeLast();
            }
            maxi.add(i);
            mini.add(i);
            ans +=arr[maxi.peekFirst()] + arr[mini.peekFirst()];
        }
        return ans ;
    }

    public static void main(String Args[]) {
        Sum_of_maxi_and_mini s = new Sum_of_maxi_and_mini();

        int arr[] = {2,5,-1,7,-3,-1,-2};

        int k=4;
        System.out.println(s.solve(arr,k));

    }
}
