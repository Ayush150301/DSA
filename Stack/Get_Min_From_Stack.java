import java.util.*;
class GfG
{
    Stack<Integer> s=new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        if(s.isEmpty())
        {
            return -1;
        }
        return Collections.min(s);
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty())
        return -1;
        
        int data=s.pop();
        return data;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(s.isEmpty())
        {
            s.push(x);
        }
        else
        {
            s.push(x);
        }
    }	
}




    
