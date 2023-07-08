import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = map.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps,
                ps + ri - is - 1, map);
        TreeNode rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder,
                ps + ri - is, pe - 1, map);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int postorder[], inorder[];
        // input for first and second arrays
        System.out.println("\nenter elements of Postorder array: ");
        postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }
        System.out.println("\nenter elements of Inorder array: ");
        inorder = new int[n];
        for (int j = 0; j < n; j++) {
            inorder[j] = sc.nextInt();
        }
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal ob = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        TreeNode root = ob.buildTree(inorder, postorder);
        System.out.println("The Binary tree created is -->");
        ob.levelordertraversal(root);

    }
}
