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

public class BinaryTree_Maximum_Path_Sum {
    public int pathsum(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }
        int lh = Math.max(0, pathsum(root.left, sum));
        int rh = Math.max(0, pathsum(root.right, sum));
        sum[0] = Math.max(sum[0], (lh + rh + root.val));
        return root.val + Math.max(lh, rh);
    }

    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        pathsum(root, sum);
        return sum[0];
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
        BinaryTree_Maximum_Path_Sum tree = new BinaryTree_Maximum_Path_Sum();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The maximum depth of the binary tree is " + tree.maxPathSum(root));
    }
}
