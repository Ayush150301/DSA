import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Ceil_from_BST {
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int ceil=-1;
        while(root!=null)
        {
            if(key==root.val)
            {
                ceil=root.val;
                return ceil;
            }
            if(key>root.val)
            {
                root=root.right;
            }
            else{
                ceil=root.val;
                root=root.left;
            }
        }
        return ceil;
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

    public Node insertinBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.val) {
            root.left = insertinBST(root.left, data);
        } else {
            root.right = insertinBST(root.right, data);
        }
        return root;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        Ceil_from_BST tree = new Ceil_from_BST();
        Node root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        System.out.println("Enter the value -> ");
        int value=sc.nextInt();
        int val=tree.findCeil(root,value);
        System.out.println("The Minimum value of the Tree --> " +val);

    }
}
