package client.dto;

import client.model.Node;

import java.util.HashMap;
import java.util.List;

public class ClientInitMessage {
    private int yourPoint;
    private int enemyPoint;
    private int turn;
    private HashMap<String, String> edges;
    private List<Node> nodes;

    public int getYourPoint() {
        return yourPoint;
    }

    public int getEnemyPoint() {
        return enemyPoint;
    }

    public int getTurn() {
        return turn;
    }

    public HashMap<String, String> getEdges() {
        return edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
