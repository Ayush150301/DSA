import java.util.*;

class Largest_Rectangle_of_Histogram{
    public int solve(int arr[],int n)
    {
        Stack<Integer> st=new Stack<>();
        int ls[]=new int[n];
        int rs[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            while(!st.empty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.empty()) ls[i]=0;
            else ls[i]=st.peek()+1;

            st.push(i);
        }
        for(int i=n-1;i>=0;i--)
        {
            while(!st.empty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }

            if(st.empty()) rs[i]=n-1;
            else rs[i]=st.peek()-1;

            st.push(i);
        }
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,arr[i]*(rs[i]-ls[i]+1));
        }
        return max;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the array --> ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Largest_Rectangle_of_Histogram obj=new Largest_Rectangle_of_Histogram();
        int area=obj.solve(arr,n);
        System.out.println("The largest rectangle area is --> "+area);       
    }
}