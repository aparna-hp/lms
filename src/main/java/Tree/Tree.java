package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    Node root;

    public static void main(String[] args) {
        Tree tree = new Tree(1);
        Node child1 = tree.addNode(2, tree.root);
        Node child2 = tree.addNode(3, tree.root);
        tree.addNode(4, child1);
        tree.addNode(5, child1);
        tree.addNode(6,child1);

        tree.addNode(7, child2);
        Node child3 = tree.addNode(8, child2);
        tree.addNode(9,child2);

        tree.addNode(10,child3);

        tree.levelOrder(tree.root);

        System.out.println("Depth = " + tree.findDepth(tree.root, 0,0));

    }

    public Tree(int value) {
        Node node = new Node();
        node.value = value;
        root = node;
    }

    public Node addNode(int value, Node parent){
        Node node = new Node();
        node.value = value;
        parent.children.add(node);
        return node;
    }

    public void levelOrder(Node node) {
        if(node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.value);
            queue.addAll(temp.children);
        }
    }

    public int findDepth(Node node, int height, int maxHeight) {
        if(root == null || node.children.size() == 0) {
            return maxHeight;
        }

        height++;

        if(maxHeight < height) {
            maxHeight = height;
        }

        for(Node child : node.children) {
             int temp = findDepth(child, height, maxHeight);
             if(temp > maxHeight) {
                 maxHeight = temp;
             }
        }
        return maxHeight;
    }

}
