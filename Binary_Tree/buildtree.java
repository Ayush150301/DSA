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

    // Iterative way of Preorder Traversal
    public List<Integer> iterativepreorderTraversal(Node root, List<Integer> res) {
        if (root == null)
            return res;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.data);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return res;
    }

    // Iterative way of Inorder Traversal
    public List<Integer> iterativeInorderTraversal(Node root, List<Integer> res) {
        if (root == null)
            return res;
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                res.add(node.data);
                node = node.right;
            }
        }
        return res;
    }

    // Iterative way of Postorder Traversal using two stacks
    public List<Integer> iterativePostorderTraversal(Node root, List<Integer> res) { // using two stacks
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if (root == null)
            return res;
        st1.push(root);
        while (!st1.isEmpty()) {
            Node node = st1.pop();
            st2.push(node);
            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }
        while (!st2.isEmpty()) {
            res.add(st2.pop().data);
        }
        return res;
    }

    // Iterative way of Postorder Traversal using one stack
    public List<Integer> iterativePostorderTraversal2(Node root, List<Integer> res) {
        Stack<Node> st = new Stack<>();
        if (root == null)
            return res;
        Node curr = root;
        Node temp;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    res.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        res.add(temp.data);
                    }
                } else
                    curr = temp;
            }
        }
        return res;
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
        root = tree.build(tree.root);

        // Input -->> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        // level Order
        // System.out.println("Enter the data in level order format --> ");
        // n = tree.buildfromlevelorder(root);

        System.out.println("Printing the level order traversal output --> ");
        tree.levelordertraversal(root);

        // root = n;

        // Inorder
        System.out.println("Printing the inorder traversal --> ");
        tree.inorder(root);
        System.out.println();

        System.out.println("Printing the inorder traversal using iterative way --> ");
        List<Integer> res1 = new ArrayList<>();
        res1 = tree.iterativeInorderTraversal(root, res1);
        System.out.println(res1);

        // Preorder
        System.out.println("Printing the preorder traversal --> ");
        tree.preorder(root);
        System.out.println();

        System.out.println("Printing the preorder using iterative way --> ");
        List<Integer> res = new ArrayList<>();
        res = tree.iterativepreorderTraversal(root, res);
        System.out.println(res);

        // PostOrder
        System.out.println("Printing the postorder traversal --> ");
        tree.postorder(root);
        System.out.println();

        System.out.println("Printing the postorder using iterative way using 2 stacks  --> ");
        List<Integer> res3 = new ArrayList<>();
        res3 = tree.iterativePostorderTraversal(root, res3);
        System.out.println(res3);

        System.out.println("Printing the postorder using iterative way using 1 stacks  --> ");
        List<Integer> res4 = new ArrayList<>();
        res4 = tree.iterativePostorderTraversal2(root, res4);
        System.out.println(res4);
    }
}