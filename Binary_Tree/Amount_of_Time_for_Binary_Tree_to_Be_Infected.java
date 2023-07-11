import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    TreeNode origin = null;

    private void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parent_track, int start) {
        if (root == null)
            return;
        if (root.left != null) {
            parent_track.put(root.left, root);
        }
        if (root.right != null) {
            parent_track.put(root.right, root);
        }
        if (root.val == start) {
            origin = root;
        }
        markParents(root.left, parent_track, start);
        markParents(root.right, parent_track, start);
    }
    // Function to find out how much time it takes for a binary tree

    public int amountOfTime(TreeNode root, int start) {
        int time = 0;
        if (root == null) {
            return time;
        }
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, start);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(origin);

        HashSet<TreeNode> visited = new HashSet<>();

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode current = q.poll();
                visited.add(current);

                if (current.left != null && !visited.contains(current.left))
                    q.add(current.left);

                if (current.right != null && !visited.contains(current.right))
                    q.add(current.right);

                if (parent_track.containsKey(current) && !visited.contains(parent_track.get(current)))
                    q.add(parent_track.get(current));
            }
            time++;
        }
        return time - 1;
    }

    public TreeNode build(TreeNode root) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data -->");
        int data = sc.nextInt();
        root = new TreeNode(data);

        if (data == -1) {
            return null;
        }
        System.out.println("Enter the left child of " + data);
        root.left = build(root.left);
        System.out.println("Enter the right child of " + data);
        root.right = build(root.right);
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        Amount_of_Time_for_Binary_Tree_to_Be_Infected tree = new Amount_of_Time_for_Binary_Tree_to_Be_Infected();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("Enter the value of Infected TreeNode -->");
        int start = sc.nextInt();
        System.out.println("The Amount of Time for Binary Tree to Be Infected is " + tree.amountOfTime(root, start));
    }
}
