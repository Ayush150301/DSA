import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.data = val;
    }

    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class Children_Sum_Parent {
    public void levelordertraversal(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    void reorder(Node root) {
        if (root == null)
            return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child < root.data) {
            if (root.left != null)
                root.left.data = root.data;
            else if (root.right != null)
                root.right.data = root.data;
        }

        reorder(root.left);
        reorder(root.right);

        int tot = 0;
        if (root.left != null)
            tot += root.left.data;
        if (root.right != null)
            tot += root.right.data;
        if (root.left != null || root.right != null)
            root.data = tot;
    }

    void changeTree(Node root) {
        reorder(root);
    }

    public Node build(Node root) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data -->");
        int data = sc.nextInt();
        root = new Node(data);

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
        Children_Sum_Parent tree = new Children_Sum_Parent();
        Node root = null;
        root = tree.build(root);
        tree.changeTree(root);
        System.out.println("The New Binary Tree is " );
        tree.levelordertraversal(root);
    }
}