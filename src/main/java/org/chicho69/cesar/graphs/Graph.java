package org.chicho69.cesar.graphs;

public class Graph {
    private int[][] adjacencyMatrix;
    private Node[] adjacencyList, finals;
    private String[] nodes;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(int numberOfElements, boolean isWeighted, boolean isDirected) {
        this.adjacencyMatrix = new int[numberOfElements][numberOfElements];
        this.adjacencyList = new Node[numberOfElements];
        this.finals = new Node[numberOfElements];
        this.nodes = new String[numberOfElements];
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public void createGraph(String[] nodes) {
        System.arraycopy(nodes, 0, this.nodes, 0, nodes.length);

        /*
        this.sortElements();
        this.fillMatrix();
        this.fillList();
        */
    }

    public void sortElements() {
        //
    }

    public void fillMatrix() {
        //
    }

    public void fillList() {
        //
    }
}
