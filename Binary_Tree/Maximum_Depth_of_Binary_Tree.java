import java.util.LinkedList;
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

public class Maximum_Depth_of_Binary_Tree {

    // method 1 ->
    public int levelordertraversal(TreeNode root) {
        int count = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.peek();
            q.remove();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                    count++;
                }
            } else {
                // System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return count + 1;
    }

    // method 2 -> recursive way
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l, r) + 1;
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
        Maximum_Depth_of_Binary_Tree tree = new Maximum_Depth_of_Binary_Tree();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The maximum depth of the binary tree is " + tree.maxDepth(root));
    }
}
