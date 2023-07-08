import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    // just to print the tree
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsleft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsleft, inorder, inStart, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + numsleft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int preorder[], inorder[];
        // input for first and second arrays
        System.out.println("\nenter elements of Preorder array: ");
        preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        System.out.println("\nenter elements of Inorder array: ");
        inorder = new int[n];
        for (int j = 0; j < n; j++) {
            inorder[j] = sc.nextInt();
        }
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal ob = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode root = ob.buildTree(preorder, inorder);
        System.out.println("The Binary tree created is -->");
        ob.levelordertraversal(root);

    }
}
