import java.util.*;

class intro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> st=new LinkedList();
        System.out.println("the topmost element of the queue is => "+st.peek()); 
        System.out.println("Enter the element you want to enter =>"); 
        for(int i=0;i<10;i++)
        {
            int n=sc.nextInt();
            st.add(n);
        }
        System.out.println("the topmost element of the queue is => "+st.peek()); 
        System.out.println("the size of the queue is => "+st.size());
        st.remove();
        System.out.println("the size of the queue is => "+st.size());
        st.remove(st.element()+1);
        System.out.print("The poll is =>"+st.poll());
        System.out.println("the topmost element of the queue is => "+st.peek());
        System.out.println("The queue is => "+st); 
        
    }    
}

// 10 20 30 40 50 60 70 80 90 100