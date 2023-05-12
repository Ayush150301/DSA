import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class First_negative_in_every_window {
    void display(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> arr = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            if (A[i] < 0)
                q.addLast(i);
        }

        if (q.size() > 0) {
            arr.add(A[q.peekFirst()]);
        } else {
            arr.add((long) 0);
        }

        for (int i = K; i < N; i++) {
            // removal
            if (!q.isEmpty() && i - q.peekFirst() >= K) {
                q.removeFirst();
            }

            // addition

            if (A[i] < 0) {
                q.addLast(i);
            }

            if (q.size() > 0) {
                arr.add(A[q.peekFirst()]);
            } else {
                arr.add((long) 0);
            }
        }
        long ar[] = arr.stream().mapToLong(Long::intValue).toArray();
        return ar;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        long arr[] = new long[n];
        System.out.println("Enter the element of the array ==> ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println("Enter the size of the window ==> ");
        int k = sc.nextInt();
        First_negative_in_every_window a = new First_negative_in_every_window();
        System.out.println("The inputted arry ==> ");
        a.display(arr);
        System.out.println("The new array is ==> ");
        arr = a.printFirstNegativeInteger(arr, n, k);
        a.display(arr);
    }
}
