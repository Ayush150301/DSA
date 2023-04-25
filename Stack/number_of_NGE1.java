import java.util.*;

class number_of_NGE1 {
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // public int[] count_NGEsusingStack(int arr[], int queries, int indices[]) {
    //     int NGEs[] = new int[queries];
    //     Stack<Integer> st = new Stack<>();
    //     // for(int i=0;i<arr.length;i++)
    //     // {
    //     // st.push(arr[i]);
    //     // }
    //     for (int i = 0; i < queries; i++) {
    //         for (int j = 0; j < arr.length; j++) {
    //             st.push(arr[i]);
    //         }
    //         int count = 0;
    //         while (!st.empty() && st.peek() >= arr[indices[i]]) {
    //             st.pop();
    //             count++;
    //         }
    //         NGEs[i] = count+1;
    //     }
    //     return NGEs;
    // }

    public int[] count_NGEsusingArray(int arr[], int queries, int indices[]) {
        int NGEs[] = new int[queries];
        // for(int i=0;i<arr.length;i++)
        // {
        // st.push(arr[i]);
        // }
        for (int i = 0; i < queries; i++) {
            int index=indices[i];
            int count=0;
            for(int j=index;j<arr.length;j++)
            {
                if(arr[index]<arr[j])
                count++;
            }
            NGEs[i] = count;
        }
        return NGEs;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        // System.out.println("Enter the element of the array ==> ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println("Enter the number opf queries ==>");
        int queries = sc.nextInt();
        // System.out.println("Enter the elemenst of the queries ==>");
        int indices[] = new int[queries];
        for (int i = 0; i < queries; i++) {
            indices[i] = sc.nextInt();
        }
        number_of_NGE1 obj = new number_of_NGE1();
        System.out.println("Inputed Array ==> ");
        obj.printArray(arr);
        // int result[] = obj.count_NGEsusingStack(arr, queries, indices);
        int result[] = obj.count_NGEsusingArray(arr, queries, indices);
        System.out.println("The final output ==> ");
        obj.printArray(result);
    }
}

