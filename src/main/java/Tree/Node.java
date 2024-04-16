package Tree;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int value;
    String strValue;
    Node left;
    Node right;
    List<Node> children;

    public Node(){
        children = new ArrayList<>();
    }

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(String strValue) {
        super();
        this.strValue = strValue;
        left = right = null;
        children = new ArrayList<>();
    }
}
