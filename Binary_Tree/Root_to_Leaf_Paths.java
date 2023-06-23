import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class Root_to_Leaf_Paths {
    void path(Node root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list)
    {
        list.add(root.data);
        if(root.left==null && root.right==null)
        {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(root.left!=null)
        {
            path(root.left,res,list);
        }
        if(root.right!=null)
        {
            path(root.right,res,list);
        }
        list.remove(list.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        path(root, res, new ArrayList<>());
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
        Root_to_Leaf_Paths tree = new Root_to_Leaf_Paths();
        Node root = null;
        root = tree.build(root);
        System.out.println("The top view  of the binary tree is " + tree.Paths(root));
    }
}
