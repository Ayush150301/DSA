import java.util.*;

class Maximum_Points_You_Can_Obtain_from_Cards {
    void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int maxScore(int[] cardPoints, int k) {
        int currsum=0;
        int l=0;
        int n=cardPoints.length;
        int s=cardPoints.length-k;
        for(int i=s;i<n;i++)
        {
            currsum+=cardPoints[i];
        }
        int sum=currsum;
        while(s<n)
        {
            currsum+=cardPoints[l++]-cardPoints[s++];
            sum=Math.max(sum,currsum);
        }
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array --> ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the element of the array  -> ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k --> ");
        int k=sc.nextInt();
        Maximum_Points_You_Can_Obtain_from_Cards obj=new Maximum_Points_You_Can_Obtain_from_Cards();
        System.out.println("The Inputted Array --> ");
        obj.display(arr);
        int x=obj.maxScore(arr,k);
        System.out.println("The sum of cardpoints of "+k+" cards : "+x);
    }    
}
