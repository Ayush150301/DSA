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

public class Predecessor_and_Successor {
    static Node pre = null;
    static Node suc = null;

    public static void findPreSuc(Node root, int key) {
        // code here.

        /*
         * There are two static nodes defined above pre(representing predecessor) and
         * suc(representing successor) as follows:
         * static Node pre=null,suc=null
         * You need to update these both.
         * And the data inside these classes will be printed automatically by the driver
         * code.
         */

        if (root == null)
            return;

        if (root.val > key) {
            if(suc==null)
            {
                suc=root;
            }
            else{
                if(root.val<suc.val)
                {
                    suc=root;
                }

            }
            findPreSuc(root.left, key);
        } else if(root.val<key){
            if(pre==null)
            {
                pre=root;
            }
            else{
                if(root.val>pre.val)
                {
                    pre=root;
                }
            }
            findPreSuc(root.right, key);
        }
        else{
            findPreSuc(root.left, key);
            findPreSuc(root.right, key);
        }
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

    public int minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
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
        Predecessor_and_Successor tree = new Predecessor_and_Successor();
        Node root = null;
        int data;
        System.out.println("Enter the root node --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        System.out.println("Enter the value of key -->");
        int key = sc.nextInt();
        findPreSuc(root, key);
        System.out.println("The Predecessor of the given node of the Tree --> " + pre.val);
        System.out.println("The Successor of the given node of the Tree --> " + suc.val);

    }
}
