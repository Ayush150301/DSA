import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class buildtree {
    Node root;

    buildtree(int key) {
        root = new Node(key);
    }

    buildtree() {
        root = null;
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

    public void inorder(Node root) { // LNR
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(Node root) { // NLR
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root) { // LRN
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public Node buildfromlevelorder(Node root) {
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        System.out.println("Enter the data for root -->");
        int data = sc.nextInt();
        root = new Node(data);
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            System.out.println("Enter the data for left child of " + temp.data);
            int left = sc.nextInt();
            if (left != -1) {
                temp.left = new Node(left);
                q.add(temp.left);
            }
            System.out.println("Enter the data for right child of " + temp.data);
            int right = sc.nextInt();
            if (right != -1) {
                temp.right = new Node(right);
                q.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        buildtree tree = new buildtree();

        Node root = null;
        Node n;
        // creating a tree
        // root = tree.build(tree.root);

        // Input -->> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        // level Order
        System.out.println("Enter the data in level order format --> ");
        n = tree.buildfromlevelorder(root);

        System.out.println("Printing the level order traversal output --> ");
        tree.levelordertraversal(n);

        root = n;

        // Inorder
        System.out.println("Printing the inorder traversal --> ");
        tree.inorder(root);
        System.out.println();

        // Preorder
        System.out.println("Printing the preorder traversal --> ");
        tree.preorder(root);
        System.out.println();

        // PostOrder
        System.out.println("Printing the postorder traversal --> ");
        tree.postorder(root);
        System.out.println();

    }
}