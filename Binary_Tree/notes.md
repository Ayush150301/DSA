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

# POSTORDER TRAVERSAL(LRN) using iterative way using 2  stacks --> 

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

# POSTORDER TRAVERSAL(LRN) using iterative way using 1 stacks --> 

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

# All TRAVERSAL WITH ONE CODE -->

    public void alltraversal(Node root,List<Integer> pre,List<Integer> in,List<Integer> post)
    {
        Stack<Pair> st=new Stack<Pair>();
        st.push(new Pair(root,1));
        if (root == null) return;
        while(!st.isEmpty())
        {
            Pair it=st.pop();

            if(it.num==1)
            {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left!=null)
                {
                    st.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num==2)
            {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right!=null)
                {
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.data);
            }
        }
    }