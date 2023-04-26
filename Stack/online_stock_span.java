import java.util.*;

class online_stock_span {
    public static  void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && price[st.peek()]<=price[i])
            st.pop();
            if(st.isEmpty()) ans[i]=i+1;
            else ans[i]=i-st.peek();
            st.push(i);
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array ==>");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Inputted Array ==> ");
        printArray(arr);
        int[] ans=calculateSpan(arr,n);
        System.out.println("The span array ==> ");
        printArray(ans);
    }
}
