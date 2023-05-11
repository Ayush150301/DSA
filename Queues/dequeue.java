import java.util.*;

class dequeue {
    int arr[];
    int front;
    int rear;
    int size;

    dequeue(int n) 
    {
        size=n;
        arr=new int[n];
        front=-1;
        rear=-1;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the
    // deque, and false otherwise.
    public boolean pushFront(int x) {
        // check full
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0 && rear != size - 1) {
            front = size - 1;
        } else {
            front--;
        }
        arr[front] = x;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the
    // deque, and false otherwise.
    public boolean pushRear(int x) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            front = rear = 0;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = x;
        return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is
    // empty, otherwise returns the popped element.
    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        int ans = arr[front];
        arr[front] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return ans;
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty,
    // otherwise returns the popped element.
    public int popRear() {
        if (isEmpty()) {
            return -1;
        }
        int ans = arr[rear];
        arr[rear] = -1;
        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return ans;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() {
        if ((front == 0 && rear == size - 1) || (front != 0 && rear == (front - 1) % (size - 1)))
            return true;
        else
            return false;
    }

    void display(int arr[]) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String Args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array ==>");
        int n=sc.nextInt();
        dequeue obj=new dequeue(n);
        if(obj.pushFront(1))
        System.out.println("1 pushed to the front");
        else
        System.out.println("1 is already in the deque");
        if(obj.pushRear(2))
        System.out.println("2 pushed to the rear");
        else
        System.out.println("2 is already in the deque");
        if(obj.pushFront(3))
        System.out.println("3 pushed to the front");
        else
        System.out.println("3 is already in the deque");
        if(obj.pushRear(4))
        System.out.println("4 pushed to the rear");
        else
        System.out.println("4 is already in the deque");
        if(obj.pushFront(5))
        System.out.println("5 pushed to the front");
        else
        System.out.println("5 is already in the deque");


        System.out.println("The front of the deque ==>"+obj.getFront());
        System.out.println("The rear of the deque ==>"+obj.getRear());


        if(obj.isFull())
        System.out.println("The deque is full");
        else
        System.out.println("The deque is not full");

        
        if(obj.isEmpty())
        System.out.println("The deque is empty");
        else
        System.out.println("The deque is not empty");
    }
}
