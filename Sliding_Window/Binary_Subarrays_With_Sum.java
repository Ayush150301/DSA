import java.util.*;

class Binary_Subarrays_With_Sum {
    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            map.put(sum, map.getOrDefault(sum, 0)+1);
            sum+=nums[i];
            if(map.containsKey(sum-goal))
            count+=map.get(sum-goal);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array --> ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the goal --> ");
        int goal = sc.nextInt();
        Binary_Subarrays_With_Sum b = new Binary_Subarrays_With_Sum();
        System.out.println("The inputted array --> ");
        b.display(arr);
        int count = b.numSubarraysWithSum(arr, goal);
        System.out.println("Number of subarrays with sum " + goal + " is " + count);
    }
}
