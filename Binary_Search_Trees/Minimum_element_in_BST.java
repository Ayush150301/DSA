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
public class Minimum_element_in_BST {
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

    public int minValue(TreeNode root) {
        if(root==null)
        return -1;
        while(root.left!=null)
        {
            root=root.left;
        }
        return root.val;
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
        Search_in_a_Binary_Search_Tree tree = new Search_in_a_Binary_Search_Tree();
        TreeNode root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }

        int val=tree.minValue(root);
        System.out.println("The Minimum element of the Binary Search Tree --> "+val);
    }
}
