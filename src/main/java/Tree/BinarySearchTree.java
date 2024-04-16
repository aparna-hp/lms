package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    Node root;
    private static int previousNode;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(8);
        bst.insertNode(bst.root, 4);
        bst.insertNode(bst.root, 10);
        bst.insertNode(bst.root, 1);
        bst.insertNode(bst.root, 6);
        bst.insertNode(bst.root, 7);
        bst.insertNode(bst.root, 13);
        bst.insertNode(bst.root, 14);

        bst.inOrder(bst.root);
        bst.levelOrder();
        bst.findMinAncestor(bst.root, 6, 17);

        System.out.println("Min diff " + bst.findMinDiff(bst.root, Integer.MAX_VALUE));

        bst.balanceBST();
        bst.levelOrder();
    }

    public BinarySearchTree(int val) {
        root = new Node(val);
    }

    public Node insertNode(Node node, int value) {
        if(null == node) {
            node = new Node(value);
        }

         else if(value < node.value) {
            node.left = insertNode(node.left, value);
        }

        else {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    public void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void delete(int val) {

    }

    public void findMinAncestor(Node node, int val1, int val2) {
        if (node == null) {
            System.out.println("No common ancestor ");
            return;
        }

        System.out.println("node value=" + node.value);

        if (node.value >= val1 && node.value <= val2) {
            System.out.println("Ancestor could be " + node.value);
            if (checkIfNodeExists(node,val1) && checkIfNodeExists(node, val2)) {
                System.out.println("Min Ancestor " + node.value);
            } else {
                System.out.println("The node doesn't exist.");
            }
        } else if (node.value > val1 && node.value > val2) {
            findMinAncestor(node.left, val1, val2);
        } else if (node.value <= val1 && node.value <= val2) {
            findMinAncestor(node.right, val1, val2);
        }
    }

    public boolean checkIfNodeExists(Node node, int val) {
        if(node == null) {
            return false;
        }

        if(node.value == val ){
            return true;
        }

        return checkIfNodeExists(node.left, val) || checkIfNodeExists(node.right, val);
    }

    public int findMinDiff(Node node, int minDiff) {
        if(null == node) {
            return minDiff;
        }

        findMinDiff(node.left, minDiff);
        int diff = Math.abs(previousNode - node.value);
        if(diff < minDiff) {
            minDiff = diff;
        }
        System.out.print("Node " + node.value + " prev " + previousNode + " ");
        previousNode = node.value;
        findMinDiff(node.right , minDiff);
        return minDiff;
    }

    public void levelOrder() {
        if(null == root) {
            return;
        }
        System.out.println("level over : ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("");
            while(size-- > 0) {
                Node curr = queue.poll();
                assert curr != null;
                System.out.print(curr.value + " ");
                if(null != curr.left) {
                    queue.add(curr.left);
                }
                if(null != curr.right){
                    queue.add(curr.right);
                }
            }
        }
    }

    public void balanceBST(){
        List<Integer> sortedNodes = new ArrayList<>();
        System.out.println("Sorted nodes :: " );
        populateSortedNodes(root, sortedNodes);
        root = populateTree(sortedNodes);
    }

    public void populateSortedNodes(Node node, List<Integer> sortedNodes){
        if(node == null) {
            return;
        }

        populateSortedNodes(node.left, sortedNodes);
        sortedNodes.add(node.value);
        System.out.print(node.value + " ");
        populateSortedNodes(node.right, sortedNodes);
        System.out.println();
    }

    public Node populateTree(List<Integer> sortedNodes){

        int size = sortedNodes.size();
        if(size == 0) {
            return null;
        }

        if(size == 1){
            System.out.println("Root =" + sortedNodes.get(0));
            return  new Node(sortedNodes.get(0));
        }

        int mid = size/2;
        System.out.println("Root =" + sortedNodes.get(mid)  + "Size = " + size + " Left nodes = " + sortedNodes.subList(0, mid)
               + " right nodes= = " + sortedNodes.subList(mid, size));
        Node node = new Node(sortedNodes.get(mid));
        node.left = populateTree(sortedNodes.subList(0, mid));
        node.right = populateTree(sortedNodes.subList(mid+1, size));

        return node;
    }

}
