import java.util.*;

class Two_numbers_with_odd_occurrences {
    public static int[] twoOddNum(int arr[], int n)
    {
        int ans[] = new int[2];
        int xor = 0;
        for(int i = 0; i<n; i++) xor = xor ^ arr[i];
        int count = 0;
        while(xor>0){
            if((xor&1)==1) break;
            count++;
            xor = xor >> 1;
        }
        int mask = 1 << count;
        for(int i = 0; i<n; i++){
            if((arr[i]&mask)==0){
                ans[0] = ans[0] ^ arr[i];
            }else{
                ans[1] = ans[1] ^ arr[i];
            }
        }
        if(ans[0]<ans[1]){
            ans[0] = ans[0] ^ ans[1];
            ans[1] = ans[0] ^ ans[1];
            ans[0] = ans[0] ^ ans[1];
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
        int ans[]=new int[2];
        ans=twoOddNum(arr,n);
        System.out.println("The two number of the array -->");
        for(int i=0;i<2;i++)
        {
            System.out.print(ans[i]+" ");
        }
    }
}
