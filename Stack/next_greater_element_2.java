import java.util.*;

class next_greater_element_2 {
    public void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--)
        {
            while(st.empty()==false && st.peek()<=nums[i%n])
                st.pop();
            if(i<n)
            {
                if(st.empty()==false)
                    ans[i]=st.peek();
                else
                    ans[i]=-1;
            }
            st.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array -->");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array -->");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        } 
        next_greater_element_2 obj=new next_greater_element_2();
        System.out.println("Inputed array1 ==>");
        obj.printArray(arr);
        int ans[]=new int[n];
        ans=obj.nextGreaterElements(arr);
        System.out.println("The final Array is ==>");
        obj.printArray(ans);    
    }
}
