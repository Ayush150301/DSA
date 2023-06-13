import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int value)
    {
        data=value;
    }
}
class Pair{
    Node node;
    int num;
    Pair(Node _node,int _num)
    {
        node=_node;
        num=_num;
    }
}
class allinone{
    public void alltraversal(Node root,List<Integer> pre,List<Integer> in,List<Integer> post)
    {
        Stack<Pair> st=new Stack<Pair>();
        st.push(new Pair(root,1));
        if (root == null) return;
        while(!st.isEmpty())
        {
            Pair it=st.pop();

            if(it.num==1)
            {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left!=null)
                {
                    st.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num==2)
            {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right!=null)
                {
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.data);
            }
        }
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
        Scanner sc = new Scanner(System.in);
        allinone tree = new allinone();

        Node root = null;
        // creating a tree
        root = tree.build(root);

        // Input -->> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        // level Order
        // System.out.println("Enter the data in level order format --> ");
        // n = tree.buildfromlevelorder(root);
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        tree.alltraversal(root,pre,in,post);
        System.out.println("The Preorder traversal --> "+pre);
        System.out.println("The Inorder traversal --> "+in);
        System.out.println("The Postorder traversal --> "+post);
    }
}