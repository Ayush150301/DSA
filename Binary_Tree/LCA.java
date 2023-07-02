import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }
}

public class LCA {
    public Node lca(Node root, int n1,int n2)
	{
		if (root == null || root.val == n1 || root.val == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        // result
        if (left == null)
            return right;

        else if (right == null)
            return left;

        else { // both left and right are not null , we found our result
            return root;
        }
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
        Scanner sc = new Scanner(System.in);
        LCA tree = new LCA();
        Node root = null;
        root = tree.build(root);
        System.out.println("Enter the first node whose lca you want to find : ");
        int x = sc.nextInt();
        // Node p = new Node(sc.nextInt());
        System.out.println("Enter the second node whose lca you want to find : ");
        int y = sc.nextInt();
        // Node q = new Node(sc.nextInt());
        System.out.println("The Lowest Common Ancestor of the binary tree is " + tree.lca(root, x, y).val);
    }
}
