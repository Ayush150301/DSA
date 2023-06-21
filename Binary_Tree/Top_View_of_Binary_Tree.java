import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


public class Top_View_of_Binary_Tree { 
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<Pair>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int hd=p.num;
            Node temp=p.node;
            if(map.get(hd)==null) map.put(hd,temp.data);
            if(temp.left!=null)
            {
                queue.add(new Pair(temp.left, hd-1));
            }
            if(temp.right!=null)
            {
                queue.add(new Pair(temp.right,hd+1));
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
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
        Top_View_of_Binary_Tree tree = new Top_View_of_Binary_Tree();
        Node root = null;
        root = tree.build(root);
        System.out.println("The top view  of the binary tree is " + tree.topView(root));
    }
}
