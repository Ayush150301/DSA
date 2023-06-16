import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return list;
        }
        q.offer(root);
        boolean flag=true;
        while (!q.isEmpty()) {
            int levelnum=q.size();
            List<Integer> l=new ArrayList<>(levelnum);
            for(int i=0;i<levelnum;i++)
            {
                int index=i;
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                if(flag==true) l.add(q.poll().val);
                else l.add(0, q.poll().val);
            }
            flag=!flag;
            list.add(l);
        }
        return list;
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
        Binary_Tree_Zigzag_Level_Order_Traversal tree = new Binary_Tree_Zigzag_Level_Order_Traversal();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The Zig Zag Traversal Of Binary Tree is " + tree.zigzagLevelOrder(root));
    }
}
