import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    public int key;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Bottom_View_of_Binary_Tree {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        root.key = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            int key = temp.key;
            map.put(key, temp.data);
            if (temp.left != null) {
                temp.left.key = key - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.key = key + 1;
                q.add(temp.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
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
        Bottom_View_of_Binary_Tree tree = new Bottom_View_of_Binary_Tree();
        Node root = null;
        root = tree.build(root);
        System.out.println("The top view  of the binary tree is " + tree.bottomView(root));
    }
}
