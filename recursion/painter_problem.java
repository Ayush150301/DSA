import java.util.*;

public class painter_problem {
    static boolean possible(int arr[],int n,int mid,int k)
    {
        int sum=0;
        int req=0;
        for(int i=0;i<n;i++)
        {
            if(sum+arr[i]>mid)
            {
                req++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return (req<=k);
    }
    static int search(int arr[],int n,int k)
    {
        int ans=0;
        int low=0;
        int high=0;
        int mid;
        for(int i=0;i<n;i++)
        {
            high+=arr[i];
        }
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(possible(arr,n,mid,k)==true)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }

    public static  void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array --> ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array --> ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the no of painters --> ");
        int k = sc.nextInt();
        int ans=search(arr,n,k);
        System.out.println("the possible answer --> "+ans);
    }
    
}
