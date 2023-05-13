import java.util.*;

class circular_tour {
    void display(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    int tour(int petrol[], int distance[])
    {
        int def=0;
        int balance=0;
        int start=0;
        
        for(int i=0;i<petrol.length;i++)
        {
            balance+=petrol[i]-distance[i];
            if(balance<0)
            {
                def+=balance;
                start=i+1;
                balance =0;
            }
        }

        if(def+balance>=0)
        {
            return start;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n=sc.nextInt();
        int petrol[]=new int[n];
        int distance[]=new int[n];
        System.out.println("Enter the value of amount of petrol in each petrol pump ==> ");
        for(int i=0;i<n;i++)
        {
            petrol[i]=sc.nextInt();
        }
        System.out.println("Enter the distance b/w  the petrol pumps ==> ");
        for(int i=0;i<n;i++)
        {
            distance[i]=sc.nextInt();
        }
        circular_tour obj=new circular_tour();
        System.out.println("The value of amount of petrol in each petrol pump ==> ");
        obj.display(petrol);
        System.out.println("The distance b/w  the petrol pumps ==> ");
        obj.display(distance);
        int ans=obj.tour(petrol,distance);
        System.out.println("The value of tour is ==> "+ans);
    }
}
