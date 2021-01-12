package model;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;

    public Node getNodeWithId(String nodeId) {
        for (Node node : nodes) {
            if (node.getId().equals(nodeId))
                return node;
        }
        return null;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
