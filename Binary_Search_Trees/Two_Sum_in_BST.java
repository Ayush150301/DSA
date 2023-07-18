import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
class BSTIterator {

    private Stack<TreeNode> st=new Stack<TreeNode>();
    boolean reverse=true;
    public BSTIterator(TreeNode root,boolean isReverse) {
        reverse=isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        if(reverse==false)
        pushAll(temp.right);
        else
        pushAll(temp.left);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode root)
    {
        while(root!=null){
            st.push(root);
            if(reverse==true){
                root=root.right;
            }else{
                root=root.left;
            }
        }
    }
}
public class Two_Sum_in_BST {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
        return false;

        BSTIterator l=new BSTIterator(root, false);
        BSTIterator r=new BSTIterator(root, true);

        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
    public void levelordertraversal(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode temp = q.peek();
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

    public int minValue(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public TreeNode insertinBST(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
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
        Two_Sum_in_BST tree = new Two_Sum_in_BST();
        TreeNode root = null;
        int data;
        System.out.println("Enter the root TreeNode --> ");
        data = sc.nextInt();
        while (data != -1) {
            root = tree.insertinBST(root, data);
            System.out.print("\n Enter next element (-1 to exit):-");
            data = sc.nextInt();
        }
        System.out.println("Enter the value of k -->");
        int k = sc.nextInt();
        boolean check=tree.findTarget(root, k);
        System.out.println("does two Elements exist or not of the Tree --> " +check);


    }
}
