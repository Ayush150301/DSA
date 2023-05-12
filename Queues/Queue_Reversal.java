import java.util.*;

class Queue_Reversal {
    void display(Queue<Integer> q) {
        System.out.println(q);
    }

    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        while (!q.isEmpty()) {
            st.push(q.poll());
        }

        while (!st.empty()) {
            q.add(st.pop());
        }
        // display(q);
        return q;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element you want to enter ==> ");
        int n = sc.nextInt();
        Queue<Integer> d = new ArrayDeque<>();
        System.out.println("Enter the element ==>");
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            d.add(a);
        }
        Queue_Reversal obj = new Queue_Reversal();
        System.out.print("The Inputted queue ==> ");
        obj.display(d);
        System.out.print("The new queue is ==> ");
        d = obj.rev(d);
        obj.display(d);
    }
}
