import java.util.*;

class maximum_rectangle {
    public void printArray(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] con = new int[m];

        for (int j = 0; j < m; j++) {
            con[j] = matrix[0][j] - '0';
        }

        int area = largestRectangleArea(con);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    con[j] = 0;
                } else {
                    con[j] += matrix[i][j] - '0';
                }
            }
            area = Math.max(area, largestRectangleArea(con));
        }
        return area;

    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows ==>");
        int n = sc.nextInt();
        System.out.println("Enter the no of cols ==>");
        int m = sc.nextInt();
        char arr[][] = new char[n][m];
        System.out.println("Enter the elements of the array ==>");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }
        maximum_rectangle obj = new maximum_rectangle();
        int ans = obj.maximalRectangle(arr);
        System.out.println("The Array is : ");
        obj.printArray(arr);
        System.out.println("The Maximum Area of Rectangle is : " + ans);
    }
}

/*4 4
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0 */