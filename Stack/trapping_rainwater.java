import java.util.*;

class trapping_rainwater {
    public void printArray(int arr[]) 
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int trap(int[] height)
    {
        int water=0;
        int n=height.length;
        int leftmax=height[0];
        Stack<Integer>st=new Stack<>();

        //intialize stack by inserting elements from right to left
        for(int i=n-1;i>0;i--){
            if(st.isEmpty() || st.peek()<=height[i]){
                st.push(height[i]);
            }
        }
        for(int i=1;i<n-1;i++){
            if(st.isEmpty()) break;
            int x= (Math.min(leftmax,st.peek())-height[i]);
            water+=x>0?x:0;
            leftmax=Math.max(leftmax,height[i]);
            if( st.peek()==height[i]){
                st.pop();
            }
        }
        return water;
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
        trapping_rainwater obj=new trapping_rainwater();
        System.out.println("Inputted Array ==> ");
        obj.printArray(arr);
        int water=obj.trap(arr);
        System.out.println("The water stoired is --> "+water);       
    }
}
