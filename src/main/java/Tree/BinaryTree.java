package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree("Root");
        binaryTree.root.left = new Node("L1_Left");

        binaryTree.root.left.left = new Node("L2_L_L");
        binaryTree.root.left.right = new Node("L2_L_R");

        binaryTree.root.left.right.left = new Node("L3_L_R_L");
        binaryTree.root.left.right.right = new Node("L3_L_R_R");

        binaryTree.root.right = new Node("L1_Right");
        binaryTree.root.right.right = new Node("L2_R_R");
        binaryTree.root.right.right.right = new Node("L3_R_R_R");
        binaryTree.root.right.right.right.left = new Node("L4_R_R_R_L");
        binaryTree.root.right.right.right.right = new Node("L4_R_R_R_R");
        binaryTree.root.right.right.right.left.right = new Node("L5_R_R_R_L_R");


        System.out.println("PreOrder : ");
        binaryTree.preOrderDeptFirst(binaryTree.root);
        System.out.println();

        System.out.println("In order : ");
        binaryTree.inOrderDeptFirst(binaryTree.root);
        System.out.println();

        System.out.println("Level Order : ");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();

        System.out.println("Height : ");
        System.out.println(binaryTree.findDeptRecursion(binaryTree.root));

        System.out.println("Longest diameter ");
        System.out.println(binaryTree.longestDiameter(binaryTree.root));

        binaryTree = new BinaryTree("Root");
        binaryTree.root.left = new Node("L1_Left");

        binaryTree.root.left.left = new Node("L2_L_L");
        binaryTree.root.left.right = new Node("L2_L_R");

        binaryTree.root.left.left.left = new Node("L3_L_L_L");
        binaryTree.root.left.left.right = new Node("L3_L_L_R");

        binaryTree.root.left.left.right.left = new Node("L4_L_L_R_L");
        binaryTree.root.left.left.right.left.right = new Node("L5_L_L_R_L_R");

        binaryTree.root.left.right.right = new Node("L3_L_R_R");
        binaryTree.root.left.right.right.left = new Node("L4_L_R_R_L");
        binaryTree.root.left.right.right.right = new Node("L4_L_R_R_R");
        binaryTree.root.left.right.right.right.left = new Node("L5_L_R_R_R_L");

        System.out.println("Level Order : ");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();

        System.out.println("Height : ");
        System.out.println(binaryTree.findDeptRecursion(binaryTree.root));

        System.out.println("Longest diameter ");
        System.out.println(binaryTree.longestDiameter(binaryTree.root));

        binaryTree = new BinaryTree("Root");
        binaryTree.root.left = new Node("L1_Left");
        binaryTree.root.left.left = new Node("L2_L_L");
        binaryTree.root.left.left.left = new Node("L3_L_L_L");
        binaryTree.root.left.left.left.left = new Node("L4_L_L_L_L");

        binaryTree.root.right = new Node("L1_Right");
        binaryTree.root.right.right = new Node("L2_R_R");
        binaryTree.root.right.right.right = new Node("L3_R_R_R");
        binaryTree.root.right.right.right.right = new Node("L4_R_R_R_R");

        System.out.println("Level Order : ");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();

        System.out.println("Height : ");
        System.out.println(binaryTree.findDeptRecursion(binaryTree.root));

        System.out.println("Longest diameter ");
        System.out.println(binaryTree.longestDiameter(binaryTree.root));


    }

    public BinaryTree(String value) {
        root = new Node(value);
    }

    public void inOrderDeptFirst(Node node) {
        if(node == null) {
            return;
        }
        inOrderDeptFirst(node.left);
        System.out.print(node.strValue + " ");
        inOrderDeptFirst(node.right);
    }

    public void preOrderDeptFirst(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.strValue + " ");
        preOrderDeptFirst(node.left);
        preOrderDeptFirst(node.right);
    }

    public void levelOrder(Node node) {
        if(node == null ) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.strValue + " ");
            if(null != temp.left) {
                queue.add(temp.left);
            }

            if(null != temp.right) {
                queue.add(temp.right);
            }
        }
    }



    public int findDeptRecursion(Node node) {
        if (null == node) {
            return 0;
        }

        int leftDept = findDeptRecursion(node.left);
        int rightDept = findDeptRecursion(node.right);
        return 1 + Math.max(leftDept, rightDept);
    }

    public int longestDiameter(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findDeptRecursion(node.left);
        int rightHeight = findDeptRecursion(node.right);
        int diameter = leftHeight + rightHeight + 1;

        System.out.println("Diameter at node " + node.strValue + " Left Height " + leftHeight +
                " right height " + rightHeight + " diameter " + diameter);
        return  Math.max(diameter, Math.max(longestDiameter(node.left),
                longestDiameter(node.right)));
    }

}
