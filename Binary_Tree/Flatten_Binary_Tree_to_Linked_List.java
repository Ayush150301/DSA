import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

public class Flatten_Binary_Tree_to_Linked_List {

    static TreeNode prev=null;
    public void levelordertraversal(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode temp = q.peek();
            q.remove();

            if (temp == null) {
                System.out.println();
                // System.out.print("null"+" ");
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

    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while(cur!=null)
        {
            if(cur.left!=null)
            {
                TreeNode pre=cur.left;
                while(pre.right!=null)
                {
                    pre=pre.right;
                }
                pre.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
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
        Flatten_Binary_Tree_to_Linked_List tree = new Flatten_Binary_Tree_to_Linked_List();
        TreeNode root = null;
        root = tree.build(root);
        tree.flatten(root);
        System.out.println("The Flatten Binary Tree is -->");
        tree.levelordertraversal(root);
    }
}
