import java.util.*;

class fruits_into_basket {
    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int totalFruits(int[] fruits) {
        int count=0;
        int i=0;
        int j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(i<fruits.length)
        {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0)+1);
            while(j<=i && map.size()>2)
            {
                if(map.get(fruits[j])==1)
                {
                    map.remove(fruits[j]);
                }
                else{
                    map.put(fruits[j], map.get(fruits[j])-1);
                }
                j++;
            }
            count=Math.max(count,i-j+1);
            i++;
        }
        return count;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array --> ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        fruits_into_basket ob=new fruits_into_basket();
        System.out.println("The Inputted Array --> ");
        ob.display(arr);
        int ans=ob.totalFruits(arr);
        System.out.println("Total fruits are : "+ans);
    }    
}
