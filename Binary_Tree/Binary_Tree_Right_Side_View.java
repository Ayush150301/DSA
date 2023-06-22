import java.util.List;
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

class Binary_Tree_Right_Side_View {

    public void recursion(TreeNode root,int level,List<Integer> res)
    {
        if(root==null) return;
        if(res.size()==level) res.add(root.val);
        recursion(root.right, level+1, res);
        recursion(root.left, level+1, res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        recursion(root,0,res);
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
        Binary_Tree_Right_Side_View tree = new Binary_Tree_Right_Side_View();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The right view  of the binary tree is " + tree.rightSideView(root));
    }
}