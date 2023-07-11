import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Morris_preorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null)
            {
                res.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=cur;
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    res.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null)
            {
                res.add(cur.val);
                cur=cur.right;
            }
            else{
                TreeNode prev=cur.left;
                while(prev.right!=null && prev.right!=cur)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=cur;
                    res.add(cur.val);
                    cur=cur.left;
                }
                else{
                    prev.right=null;
                    cur=cur.right;
                }
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
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        Morris_preorder tree=new Morris_preorder();
        TreeNode root=null;
        root=tree.build(root);
        List<Integer> pre=tree.preorderTraversal(root);
        System.out.println("The PreOrder Traverssal -->" + pre);
        List<Integer> in=tree.inorderTraversal(root);
        System.out.println("The InOrder Traverssal -->" + in);
    }
}
