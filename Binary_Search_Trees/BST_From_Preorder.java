import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

public class BST_From_Preorder {
    // TreeNode root=null;
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     Map<Integer,Integer> map=new HashMap<>();
    //     int inorder[]=new int[preorder.length];
    //     for(int i=0;i<preorder.length;i++)
    //     {
    //         inorder[i]=preorder[i];
    //     }
    //     Arrays.sort(inorder);
    //     for(int i=0;i<inorder.length;i++)
    //     {
    //         map.put(inorder[i], i);
    //     }
    //     TreeNode root=bstFromPreorder(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    //     return root;
    // }
    // public TreeNode bstFromPreorder(int[] preorder, int ps, int pe, int[] inorder, int is, int ie,Map<Integer,Integer> map) {
    //     if(ps>pe ||is>ie)
    //     return null;
    //     TreeNode root=new TreeNode(preorder[ps]);
    //     int inRoot=map.get(root.val);
    //     int num=inRoot-is;
    //     root.left=bstFromPreorder(preorder, ps+1, ps+num, inorder, is, inRoot-1,map);
    //     root.right=bstFromPreorder(preorder, ps+num+1, pe, inorder, inRoot+1, ie,map);
    //     return root;
    // }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if(i[0]==preorder.length || preorder[i[0]]>bound)
        return null;
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=bstFromPreorder(preorder, root.val, i);
        root.right=bstFromPreorder(preorder, bound, i);
        return root;
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
        BST_From_Preorder tree = new BST_From_Preorder();
        TreeNode root = null;
        // int data;
        // System.out.println("Enter the root node --> ");
        // data = sc.nextInt();
        // while (data != -1) {
        //     root = tree.insertinBST(root, data);
        //     System.out.print("\n Enter next element (-1 to exit):-");
        //     data = sc.nextInt();
        // }
        System.out.println("Enter the number of nodes -->");
        int n=sc.nextInt();
        int pre[]=new int[n];
        System.out.println("Enter the elements of the preorder array -->");
        for(int i=0;i<n;i++)
        {
            pre[i]=sc.nextInt();
        }
        root=tree.bstFromPreorder(pre);
        System.out.println("TheBinary Search Tree from Preorder Traversal --> ");
        tree.levelordertraversal(root);
    }
}
// 8 5 1 7 10 12