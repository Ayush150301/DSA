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

public class Symmetric_Tree {
    public boolean check(TreeNode root1,TreeNode root2)
    {
        if(root1==null || root2==null)
        {
            return root1==root2;
        }
        return (root1.val==root2.val) && check(root1.left, root2.right) && check(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return check(root.left, root.right);
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
        Symmetric_Tree tree = new Symmetric_Tree();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The binary tree is Symmetric : " + tree.isSymmetric(root));
    }
}
