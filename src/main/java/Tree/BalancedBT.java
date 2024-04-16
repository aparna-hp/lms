package Tree;

import java.util.*;

public class BalancedBT {

    Node root;
    int minIndex;

    public static void main(String[] args) {
        BalancedBT balancedBT = new BalancedBT(1);
        for(int i = 2; i <= 8; i++) {
            balancedBT.addNode(i);
        }
        balancedBT.levelOrder(balancedBT.root);
        //System.out.println("Sum of leaves = " + balancedBT.sumOfLeaves());

        balancedBT = new BalancedBT(5);
        balancedBT.addNode(-10);
        balancedBT.addNode(3);
        balancedBT.addNode(9);
        balancedBT.addNode(8);
        balancedBT.addNode(-4);
        balancedBT.addNode(7);

        balancedBT.levelOrder(balancedBT.root);
        //balancedBT.countSubtreesWithSumX(7);

        System.out.println("Zig zag order ");
        balancedBT.zigzagTraversal(balancedBT.root);

        balancedBT.differentTraversal();

    }

    public BalancedBT(int value) {
        Node node = new Node();
        node.value = value;
        root = node;
    }

    public void addNode(int value) {
        Node node = new Node();
        node.value = value;

        if(root == null) {
            root = node;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(null == temp.left) {
                temp.left = node;
                break;
            }
            queue.add(temp.left);

            if(null == temp.right) {
                temp.right = node;
                break;
            }
            queue.add(temp.right);
        }
    }

    public void levelOrder(Node node) {
        if(node == null ) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.value + " ");
            if(null != temp.left) {
                queue.add(temp.left);
            }

            if(null != temp.right) {
                queue.add(temp.right);
            }
        }
        System.out.println();
    }

    public int sumOfLeaves(){
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.left == null && temp.right == null) {
                System.out.print(temp.value + " + ");
                sum += temp.value;
            }

            if(null != temp.left) {
                queue.add(temp.left);
            }

            if(null != temp.right) {
                queue.add(temp.right);
            }
        }
        System.out.print(" = ");
        return sum;
    }
    public void countSubtreesWithSumX(int X) {
        if (root == null) {
            return;
        }
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int sum = temp.value;

            if (null != temp.left) {
                queue.add(temp.left);
                sum += temp.left.value;
            }

            if (null != temp.right) {
                queue.add(temp.right);
                sum += temp.right.value;
            }

            if(sum == X) {
                count ++;
            }
        }
        System.out.println("Count = " + count);
    }

    public void zigzagTraversal(Node root) {
        if(null == root) {
            return;
        }

        boolean rightOrder = false;
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        int level =0;

        while(!queue.isEmpty()){
            System.out.print("Level " + level++ + "::" );
            int size = queue.size();
            for(int i=0; i < size; i++) {
                Node curr = queue.poll();
                if(!rightOrder) {
                    System.out.print(curr.value + " ");
                } else {
                    stack.push(curr.value);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            while (rightOrder && !stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            }
            rightOrder = !rightOrder;
            System.out.println();
        }

    }

    public void differentTraversal() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        minIndex =0;
        verticalTraversal(root, map, 0);
        printMap(map);

        System.out.println("Diagonal Traversal :: ");
        map = new HashMap<>();
        minIndex =0;
        diagonalTraversal(root, map, 0);
        printMap(map);
    }

    public void verticalTraversal(Node node, Map<Integer, List<Integer>> verticalMap, int index) {
        if (node == null) {
            return;
        }

        verticalMap.computeIfAbsent(index, k -> new ArrayList<>());
        List<Integer> integerList = verticalMap.get(index);
        integerList.add(node.value);
        verticalMap.put(index, integerList);

        minIndex = Math.min(index, minIndex);

        verticalTraversal(node.left, verticalMap, index - 1);

        verticalTraversal(node.right, verticalMap, index + 1);

    }

    public void diagonalTraversal(Node node, Map<Integer, List<Integer>> diagonalMap, int index ){
        if(node == null) {
            return;
        }

        diagonalMap.computeIfAbsent(index, k-> new ArrayList<>());
        List<Integer> list = diagonalMap.get(index);
        list.add(node.value);
        diagonalMap.put(index, list);

        minIndex = Math.min(index, minIndex);

        diagonalTraversal(node.left, diagonalMap, index-1);
        diagonalTraversal(node.right, diagonalMap, index);
    }

    private void printMap(Map<Integer, List<Integer>> map){
        int size = map.size();
        String[] output = new String[size];

        int offset = Math.abs(minIndex);
        for(int index : map.keySet()){
            output[index+offset] = Arrays.toString(map.get(index).toArray());
        }

        System.out.println("Output " + Arrays.deepToString(output));
    }

}
