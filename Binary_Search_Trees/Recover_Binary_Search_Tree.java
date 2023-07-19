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

public class Recover_Binary_Search_Tree {
    private TreeNode first;
    private TreeNode middle;
    private TreeNode prev;
    private TreeNode last;
    private void Inorder(TreeNode root){
        if(root==null){
            return;
        }
        Inorder(root.left);

        if(prev!=null&&(root.val<prev.val)){
            if(first==null){
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        Inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        Inorder(root);
        if(first!=null && last!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;
        }
        else if(first!=null && middle!=null){
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
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
        Recover_Binary_Search_Tree tree = new Recover_Binary_Search_Tree();
        TreeNode root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        tree.recoverTree(root);
        System.out.println("The Recovered Binary Search Tree --> ");
        tree.levelordertraversal(root);
    }
}
