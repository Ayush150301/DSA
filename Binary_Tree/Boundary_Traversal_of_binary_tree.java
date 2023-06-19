import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Boundary_Traversal_of_binary_tree {
    static Boolean isLeaf(Node root)
    {
        return (root.left==null) &&(root.right==null);
    }

    void addleafBoundary(Node root,ArrayList<Integer> res)
    {
        Node cur=root.left;
        while(cur!=null)
        {
            if(isLeaf(cur)==false) res.add(cur.data);
            if(cur.left!=null)
            {
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
    }
    static void addrightBoundary(Node root,ArrayList<Integer> res)
    {
        Node cur=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(cur!=null)
        {
            if(isLeaf(cur)==false) temp.add(cur.data);
            if(cur.right!=null){
                cur=cur.right;
            }
            else cur=cur.left;
        }
        for(int i=temp.size()-1;i>=0;i--)
        {
            res.add(temp.get(i));
        }
    }

    static void addLeaves(Node root,ArrayList<Integer> res)
    {
        if(isLeaf(root))
        {
            res.add(root.data);
            return;
        }
        if(root.left!=null) addLeaves(root.left,res);
        if(root.right!=null) addLeaves(root.right,res);
    }
    public ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if(isLeaf(node)==false) list.add(node.data);
        addleafBoundary(node, list);
        addLeaves(node, list);
        addrightBoundary(node, list);
        return list;
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
        Boundary_Traversal_of_binary_tree tree = new Boundary_Traversal_of_binary_tree();
        Node root = null;
        root = tree.build(root);
        System.out.println("The Boundary traverasl of the binary tree is " + tree.boundary(root));
    }
}
