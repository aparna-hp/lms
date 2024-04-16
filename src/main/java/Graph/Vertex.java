package Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    int value;
    List<Vertex> adjacentNode;

    public Vertex(){
        adjacentNode = new ArrayList<>();
    }

    public Vertex(int val) {
        super();
        this.value = val;
        adjacentNode = new ArrayList<>();
    }
}
