import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    int num;
    Node node;

    Pair(int _num, Node _node) {
        num = _num;
        node = _node;
    }
}

/*
Self Notes
 * Mark each node to its parent to traverse upwards
 * We will do a BFS traversal starting from the target node
 * As long as we have not seen our node previously, Traverse up, left, right until reached Kth distance
 * when reached Kth distance, break out of BFS loop and remaining node's values in our queue is our result
 */

public class All_Nodes_Distance_K_in_Binary_Tree {
    private void markParents(Node root, Map<Node, Node> parent_track, Node target) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public ArrayList<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track, target);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!queue.isEmpty()) {  
            int size = queue.size();
            if (curr_level == k)
                break;
            curr_level++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.val);
        }
        return result;
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
        All_Nodes_Distance_K_in_Binary_Tree tree = new All_Nodes_Distance_K_in_Binary_Tree();
        Node root = null;
        root = tree.build(root);
        System.out.println("Enter the target node value -->");
        Node target = new Node(sc.nextInt());
        System.out.println("Enter the distance --> ");
        int k = sc.nextInt();
        ArrayList<Integer> res=new ArrayList<>();
        res=tree.distanceK(root, target, k);
        System.out.println("The Node at a distance are  --> " + res);
    }
}
