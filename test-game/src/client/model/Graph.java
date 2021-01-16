package client.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getAllNodes() {
        return nodes;
    }
}
