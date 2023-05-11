import java.util.*;

class circularqueue {
    int size = 5;
    int arr[] = new int[size];
    int front = -1;
    int rear = -1;

    circularqueue(int size) {
        size = size;
    }

    void enqueue(int x) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
        } else {
            if (front == -1 && rear == -1) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % size;
            }
            arr[rear] = x;
            System.out.println("Element inserted");
        }

    }

    int dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int x = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return x;
        }
    }

    void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
        } else {
            if (front > rear) {
                int x = front;
                while (x != rear) {
                    System.out.print(arr[x] + " ");
                    x = (x + 1) % size;
                }
                System.out.print(arr[x] + " ");
            } else {
                int x = front;
                while (x != rear) {
                    System.out.print(arr[x] + " ");
                    x = (x + 1) % size;
                }
                System.out.print(arr[x] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        circularqueue q = new circularqueue(n);
        System.out.println("Enter the elements to be inserted in the queue ==> ");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            q.enqueue(x);
        }
        q.display();
        System.out.println("Dequeued element is : " + q.dequeue());
        q.display();
    }
}
