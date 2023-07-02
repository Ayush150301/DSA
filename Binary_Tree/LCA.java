import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // result
        if (left == null)
            return right;

        else if (right == null)
            return left;

        else { // both left and right are not null , we found our result
            return root;
        }
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
        LCA tree = new LCA();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("Enter the first node whose lca you want to find : ");
        // int x = sc.nextInt();
        TreeNode p = new TreeNode(sc.nextInt());
        System.out.println("Enter the second node whose lca you want to find : ");
        // int y = sc.nextInt();
        TreeNode q = new TreeNode(sc.nextInt());
        System.out.println("The Lowest Common Ancestor of the binary tree is " + tree.lowestCommonAncestor(root, p, q).val);
    }
}
