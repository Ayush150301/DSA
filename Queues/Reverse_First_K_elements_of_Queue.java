import java.util.*;

class Reverse_First_K_elements_of_Queue {
    void display(Queue<Integer> q) {
        System.out.println(q);
    }
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> a=new ArrayDeque<>();
        Deque<Integer> n=new ArrayDeque<>();
        while(k-->0)
        {
            a.add(q.remove());
        }
        while(!q.isEmpty())
        {
            n.addLast(q.remove());
        }
        while(!a.isEmpty())
        {
            n.addFirst(a.remove());
        }
        return n;
    }
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        Queue<Integer> q=new ArrayDeque<>();
        System.out.println("Enter the element of the array ==> ");
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            q.add(a);
        }
        System.out.println("Enter the size of the window ==> ");
        int k = sc.nextInt();
        Reverse_First_K_elements_of_Queue a=new Reverse_First_K_elements_of_Queue();
        System.out.print("The Inputted array ==> ");
        a.display(q);
        q=a.modifyQueue(q, k);
        System.out.print("The modified queue ==>");
        a.display(q);
    }    
}
