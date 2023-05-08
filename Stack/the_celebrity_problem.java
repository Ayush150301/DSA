import java.util.*;

class the_celebrity_problem {
    public boolean know(int arr[][], int a, int b, int n) {
        if (arr[a][b] == 1)
            return true;
        else
            return false;
    }

    public void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();

        // Step 1-> push all elements in stack

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2-> get 2 elements and compare them

        while (stack.size() > 1) {
            int a = stack.peek();
            stack.pop();

            int b = stack.peek();
            stack.pop();

            if (know(M, a, b, n)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        // Step 3-> single element of the stack is a potential candidate
        // so verfiy it

        // ---> Row Check

        int candidate = stack.peek();
        int zerocount = 0;

        for (int i = 0; i < n; i++) {
            if (M[candidate][i] == 0)
                zerocount++;
        }

        // if all zeros

        if (zerocount != n) {
            return -1;
        }

        // ---> Column Check

        int onecount = 0;

        for (int i = 0; i < n; i++) {
            if (M[i][candidate] == 1)
                onecount++;
        }

        if (onecount != n - 1) {
            return -1;
        }

        // --> checking both the conditions

        return candidate;

    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the size of the matrix ==> ");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        // System.out.println("Enter the elements of the matrix ==> ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        the_celebrity_problem obj = new the_celebrity_problem();
        System.out.println("The Inputted Array ==> ");
        obj.printArray(arr);
        System.out.println("The number of celebrity in the party are " + obj.celebrity(arr, n));
    }
}
