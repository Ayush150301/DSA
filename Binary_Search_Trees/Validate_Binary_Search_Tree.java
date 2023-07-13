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

public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long min,long max)
    {
        if(root==null) return true;
        if(root.val>=max || root.val<=min) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max); 
    }
    public void levelordertraversal(TreeNode root) {

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
                }
            } else {
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public TreeNode insertinBST(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.val) {
            root.left = insertinBST(root.left, data);
        } else {
            root.right = insertinBST(root.right, data);
        }
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        Validate_Binary_Search_Tree tree = new Validate_Binary_Search_Tree();
        TreeNode root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        System.out.println("The Valid Binary Search Tree --> "+tree.isValidBST(root));
    }
}
