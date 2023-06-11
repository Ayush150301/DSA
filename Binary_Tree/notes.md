# Basic Terms

    - Node
    - Root
    - Children
    - Parents
    - Sibling
    - Ancestors
    - Descendents
    - Leaf

# Implementation

    class Node{
        int value;
        Node left;
        Node right;
    }

# Building A Tree

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

# Level Order traversal

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

# INORDER TRAVERSAL(LNR)

    public void inorder(Node root) { 
        if (root == null) {
        return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

# INORDER TRAVERSAL(LNR) using iterative way 

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

# PREORDER TRAVERSAL(NLR)

    public void preorder(Node root) {  
        if (root == null) {
            return ;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

# PREORDER TRAVERSAL(NLR) using iterative way --> 

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
# POSTORDER TRAVERSAL(LRN)

    public void postorder(Node root) { 
        if (root == null) {
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
