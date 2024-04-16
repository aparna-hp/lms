package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    Vertex[] vertices;
    int numOfVerticies;

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addAdjacency(1, 2);
        graph.addAdjacency(2,3);
        graph.addAdjacency(3,4);
        graph.addAdjacency(4,5);
        graph.addAdjacency(5,6);
        graph.addAdjacency(6,7);
        graph.addAdjacency(7,8);
        graph.addAdjacency(8,9);
        graph.addAdjacency(1,5);
        graph.addAdjacency(2,6);
        graph.addAdjacency(3,7);
        graph.addAdjacency(4,8);

        graph.printGraph();

        graph.breathSearch(graph.vertices[0]);
        System.out.println("Dept search :: ");
        graph.depthSearch(graph.vertices[0], new boolean[graph.numOfVerticies]);

        graph.countComponent();
    }

    public Graph(int size){
        vertices = new Vertex[size];
        numOfVerticies = size;
        for(int i=0; i<size; i++) {
            vertices[i] = new Vertex(i+1);
        }
    }

    public void addAdjacency(int fromVertex, int toVertex) {
        if(fromVertex <= numOfVerticies && toVertex <= numOfVerticies) {
            vertices[fromVertex-1].adjacentNode.add(vertices[toVertex-1]);
            vertices[toVertex-1].adjacentNode.add(vertices[fromVertex-1]);
        }
    }

    public void printGraph(){
        for(int i=0; i<numOfVerticies; i++) {
            System.out.println();
            System.out.print(vertices[i].value + "::");
            vertices[i].adjacentNode.forEach(vertex -> System.out.print(vertex.value + " "));
        }
    }

    public void breathSearch(Vertex vertex) {
        System.out.println("Breath serach :");
        Queue<Vertex> queue = new LinkedList<>();
        boolean[] visitedVertex = new boolean[numOfVerticies];
        queue.add(vertex);

        while(!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if(!visitedVertex[curr.value -1]) {
                System.out.print(curr.value + " ");
                visitedVertex[curr.value - 1] = true;
                queue.addAll(curr.adjacentNode);
            }
        }
        System.out.println();
    }

    public void depthSearch(Vertex vertex, boolean[] visitedVertex){
        if(null == vertex || visitedVertex[vertex.value-1] ) {
            return;
        }
        System.out.print(vertex.value + " ");
        visitedVertex[vertex.value-1] = true;
        vertex.adjacentNode.forEach(adjVertex -> depthSearch(adjVertex, visitedVertex));
    }

    public void countComponent(){
        boolean[] visitedNodes = new boolean[numOfVerticies];
        int count =0;

        for(int i=0; i<numOfVerticies; i++){
            if(!visitedNodes[i]) {
                System.out.println("Dept search started with index " + i);
                depthSearch(vertices[i], visitedNodes);
                count++;
            }
        }

        System.out.println("No. of islands " + count);
    }
}
