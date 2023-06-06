// exactly(k)=atmost(k)-atmost(k-1); done in the main function

import java.util.*;

class Subarrays_with_K_Different_Integers {
    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    //  atmost function -> to calculate atmost k distinct integer

    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() == k+1) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0)
                    map.remove(nums[j]);
                j++;
            }
            count+=i-j+1;
            i++;
        }
        return count;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array --> ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k --> ");
        int k = sc.nextInt();
        Subarrays_with_K_Different_Integers s = new Subarrays_with_K_Different_Integers();
        System.out.println("The Inputted Array --> ");
        s.display(arr);
        int ans = s.subarraysWithKDistinct(arr, k)-s.subarraysWithKDistinct(arr, k-1);
        System.out.println("The number of subarrays with " + k + " different integers is : " + ans);
    }
}
