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

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}

public class Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; ++i) {
                int cur_id = queue.peek().num - min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if (i == 0)
                    first = cur_id;
                if (i == size - 1)
                    last = cur_id;
                if (node.left != null) {
                    queue.offer(new Pair(node.left, cur_id * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, cur_id * 2 + 2));
                }
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
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
        Maximum_Width_of_Binary_Tree tree = new Maximum_Width_of_Binary_Tree();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The Maximum width of the binary tree is " + tree.widthOfBinaryTree(root));
    }
}
