import java.util.Scanner;

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

class Diameter_of_Binary_Tree {
    int find(TreeNode root,int[] diameter) // pass by reference in java by passing the array of size of one
    {
        if(root==null)
        return 0;

        int lh=find(root.left,diameter);
        int rh=find(root.right,diameter);
        diameter[0]=Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter=new int[1];
        find(root,diameter);
        return diameter[0];
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
        Diameter_of_Binary_Tree tree = new Diameter_of_Binary_Tree();
        TreeNode root = null;
        root = tree.build(root);
        System.out.println("The maximum depth of the binary tree is " + tree.diameterOfBinaryTree(root));
    }
    
}
