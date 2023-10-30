package Dynamic_Programming.DP_on_Squares;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Maximal_Rectangle {
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
        int maxArea = 0;
        int[] con = new int[m];
        Arrays.fill(con, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    con[j]++;
                else
                    con[j] = 0;
            }
            int area = largestRectangleArea(con);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n amd m : ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        arr[]={{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        Maximal_Rectangle obj = new Maximal_Rectangle();
        System.out.print("Maximum Area is : " + obj.maximalRectangle(arr));
    }
}
