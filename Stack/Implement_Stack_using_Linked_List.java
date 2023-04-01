class MyStack 
{
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        StackNode n=new StackNode(a);
        if(top==null)
        {
            top=n;
        }
        else
        {
            n.next=top;
            top=n;
        }
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        int data=0;
        if(top==null)
        {
            return -1;
        }
        else
        {
            data=top.data;
            top=top.next;
        }
        return data;
    }
}

