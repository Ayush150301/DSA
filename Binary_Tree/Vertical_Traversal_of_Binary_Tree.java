import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node,int _row,int _col)
    {
        node=_node;
        row=_row;
        col=_col;
    }
}
public class Vertical_Traversal_of_Binary_Tree{
    public List<Integer> verticalTraversal(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                res.add(nodeVal);
            }
        }
        return res;
    }
    public TreeNode build(TreeNode root) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data -->");
        int data = sc.nextInt();
        root = new TreeNode(data);

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
        Vertical_Traversal_of_Binary_Tree tree = new Vertical_Traversal_of_Binary_Tree();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The top view  of the binary tree is " + tree.verticalTraversal(root));
    }
}