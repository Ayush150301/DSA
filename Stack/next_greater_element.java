import java.util.*;

class next_greater_element {
    public void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int next[]=new int[10001];
        Arrays.fill(next,-1);
        for(int num:nums2)
        {
            while(!st.isEmpty() && st.peek()<num)
            {
                next[st.pop()]=num;
            }
            st.push(num);
        }
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            res[i]=next[nums1[i]];
        }
        return res;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array1 -->");
        int n=sc.nextInt();
        System.out.println("Enter the size of the array2 -->");
        int m=sc.nextInt();
        int arr1[]=new int[n];
        int arr2[]=new int[m];
        System.out.println("Enter the elements of the array1 -->");
        for(int i=0;i<n;i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("Enter the elements of the array2 -->");
        for(int i=0;i<m;i++)
        {
            arr2[i]=sc.nextInt();
        }
        next_greater_element obj=new next_greater_element();
        System.out.println("Inputed array1 ==>");
        obj.printArray(arr1);
        System.out.println("Inputed array2 ==>");
        obj.printArray(arr2);
        int ans[]=new int[n];
        ans=obj.nextGreaterElement(arr1,arr2);
        System.out.println("The final Array is ==>");
        obj.printArray(ans);    
    }
}
