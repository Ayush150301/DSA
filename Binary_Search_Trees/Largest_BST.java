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
        this.data= val;
    }

    Node(int val, Node left, Node right) {
        this.data= val;
        this.left = left;
        this.right = right;
    }
}

class Nodevalue {
    public int minNode, maxNode, maxSize;

    Nodevalue(int minNode, int maxNode, int maxSize) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
};

public class Largest_BST {
    public int largestBst(Node root)
    {
        return largestBSTtreeHelper(root).maxSize;
    }

    private Nodevalue largestBSTtreeHelper(Node root) {
        if(root==null)
        {
            return new Nodevalue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Nodevalue left=largestBSTtreeHelper(root.left);
        Nodevalue right=largestBSTtreeHelper(root.right);

        if(left.maxNode<root.data&& root.data<right.minNode){
            return new Nodevalue(Math.min(root.data,left.minNode), Math.max(root.data,right.maxNode),left.maxSize+right.maxSize+1);
        }
        return new Nodevalue(Integer.MIN_VALUE, Integer.MAX_VALUE,Math.max(left.maxSize, right.maxSize));
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
                System.out.print(temp.data+ " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public Node insertinBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertinBST(root.left, data);
        } else {
            root.right = insertinBST(root.right, data);
        }
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        Largest_BST tree = new Largest_BST();
        Node root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        System.out.println("The largest Sized Binary Search Tree --> "+tree.largestBst(root));
    }

}
