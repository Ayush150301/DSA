import java.util.*;

class NStack {
    int arr[];   // Array of size n to store actual content to be stored in stacks
    int top[];   // Array of size k to store indexes of top elements of stacks
    int next[];  // Array of size n to store next entry in all stacks
                 // and free list
    int n, k;
    int free; // To store beginning index of free list
    public NStack(int N, int S) {
        n=N;
        k=S;
        arr=new int[k];
        top=new int[n];
        next=new int[k];

        // top initalise
        for(int i=0;i<n;i++)
        {
            top[i]=-1;
        }

        //next initalise
        for(int i=0;i<k;i++)
        {
            next[i]=i+1;
        }

        //update last index value to -1
        next[k-1]=-1;

        //initalise freespot
        free=0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        //check for overflow
        if(free==-1)
        {
            return false;
        }
        
        //find index
        int index=free;

        //update freespot
        free=next[index];

        //insert element into array 
        arr[index]=x;

        //update next
        next[index]=top[m-1];

        //update top
        top[m-1]=index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        //check for underflow
        if(top[m-1]==-1)
        {
            return -1;
        }

        int index=top[m-1];

        top[m-1]=next[index];

        next[index]=free;

        free=index;

        return arr[index];
    }
    public static void main(String Args[])
    {
         // Let us create 3 stacks in an array of size 10
        int k = 3, n = 10;
         
        NStack ks = new NStack(k, n);
 
        ks.push(15, 2);
        ks.push(45, 2);
 
        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
 
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
 
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }    
}
/*Step-1 -> find index
 *          int index=freespot;
 * 
 * Step-2 ->freespot update
 *          freespot=next[index];
 * 
 * Step-3 ->insert in array
 *          arr[index]=x;
 * 
 * Step-4 ->update next
 *          next[update]=top[m-1];
 * 
 * Step-5 ->update top
 *          top[m-1]=index; 
 */