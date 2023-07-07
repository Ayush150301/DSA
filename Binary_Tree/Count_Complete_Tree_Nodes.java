import java.util.ArrayList;
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

public class Count_Complete_Tree_Nodes {
    ArrayList<Integer> res=new ArrayList<>();
    public int countNodes(TreeNode root) {
        if(root!=null)
        {
            countNodes(root.left);
            res.add(root.val);
            countNodes(root.right);
        }
        return res.size();
        //return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
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
        Count_Complete_Tree_Nodes tree = new Count_Complete_Tree_Nodes();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The number of nodes in the tree are " + tree.countNodes(root));
    }
}
