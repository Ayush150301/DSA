import java.util.*;

class Asteroid_Collision_problem {
    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                st.push(a);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a)) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(a);
                }
                if (st.peek() == Math.abs(a)) {
                    st.pop();
                }
            }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array ==> ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array ==> ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Asteroid_Collision_problem a = new Asteroid_Collision_problem();
        System.out.println("Inputted Array ==> ");
        a.printArray(arr);
        int[] result = a.asteroidCollision(arr);
        System.out.println("Result ==> ");
        a.printArray(result);
    }
}
