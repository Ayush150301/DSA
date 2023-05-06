import java.util.*;

class sum_of_subarray_min {
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long) 1e9 + 7;
        stack.push(-1);
        for (int i2 = 0; i2 < arr.length + 1; i2++) {
            int currVal = (i2 < arr.length) ? arr[i2] : 0;

            while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (long) (left * right * (long) arr[index]) % M;
                res += add;
                res %= M;
            }
            stack.push(i2);
        }
        return (int) res;

    }

    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the the size of the array ==>");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array ==>");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sum_of_subarray_min s=new sum_of_subarray_min();
        System.out.println("Inputted array ==>");
        s.printArray(arr);
        int res=s.sumSubarrayMins(arr);
        System.out.println("The sum of the subarray mins is "+res);
    }
}
