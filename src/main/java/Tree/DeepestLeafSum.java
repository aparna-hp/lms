package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeafSum {

    Node root;

    public static void main(String[] args){
        DeepestLeafSum tree = new DeepestLeafSum(38);
        tree.addChildNode(tree.root, 43, 70);
        tree.addChildNode(tree.root.left, 16, null);
        tree.addChildNode(tree.root.right, 78, 91);
        tree.addChildNode(tree.root.right.left, 71, 27);
        tree.addChildNode(tree.root.right.right, null, 71);
        tree.addChildNode(tree.root.right.right.right, null, 71);

        int maxDept = tree.dept(tree.root);
        System.out.println("max dept = " + maxDept);

        int sum = tree.sumOfDeepestNode(tree.root, maxDept);
        System.out.println("Sum = " + sum);

        sum = tree.sumOfDNUsingQueue(tree.root);
        System.out.println("Sum = " + sum);
    }

    public DeepestLeafSum(int value) {
        Node node = new Node();
        node.value = value;
        root = node;
    }

    public void addChildNode(Node node, Integer left, Integer right) {

        if(null != left){
            Node leftNode = new Node();
            leftNode.value = left;
            node.left = leftNode;
        }

        if(null != right){
            Node rightNode = new Node();
            rightNode.value = right;
            node.right = rightNode;
        }
    }

    public int dept(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(dept(node.left), dept(node.right));
    }

    public int sumOfDeepestNode(Node node, int dept) {
        if(node == null) {
            return 0;
        }

        if(dept == 1) {
            return node.value;
        }

        return sumOfDeepestNode(node.left, dept-1) + sumOfDeepestNode(node.right, dept-1);
    }

    public int sumOfDNUsingQueue(Node node) {
        if(null == node) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i =0, sum = 0;
        while(!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            while(size-- > 0) {
                Node temp = queue.poll();
                sum += temp.value;
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println("Level " + ++i + " Sum = " + sum);
        }

        return sum;
    }
}
