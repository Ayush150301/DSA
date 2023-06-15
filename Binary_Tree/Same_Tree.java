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

public class Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return ((p.val==q.val)&& isSameTree(p.left, q.left)&&isSameTree(p.right, q.right));
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
        Same_Tree tree = new Same_Tree();
        TreeNode root1 = null;
        TreeNode root2 = null;
        System.out.println("Enter the data of tree 1");
        root1 = tree.build(root1);
        System.out.println("Enter the data of tree 2");
        root2 = tree.build(root2);
        System.out.println("The binary tree is Identical ->  " + tree.isSameTree(root1, root2));
    }
}
