package client.model;

import client.dto.ClientInitMessage;
import client.model.enums.Owner;
import com.google.gson.JsonObject;
import common.network.Json;
import common.network.data.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class Game {
    private Graph graph;
    private int myPoint;
    private int enemyPoint;
    private int turn;
    private Consumer<Message> sender;

    public Game(Consumer<Message> sender) {
        this.sender = sender;
    }

    /*
     * @return list of game nodes
     * @param owner the owner of wanted nodes (MINE\ENEMY\FREE\)
     */
    public List<Node> getNodes(Owner owner) {
        List<Node> nodes = new ArrayList<>();
        for (Node node : graph.getAllNodes()) {
            if (node.getOwner() == owner) {
                nodes.add(node);
            }
        }
        return nodes;
    }

    public List<Node> getAllNodes() {
        return graph.getAllNodes();
    }

    /*
     * @return wanted node
     * @param nodeId the id of wanted node
     */
    public Node getNodeWithId(String nodeId) {
        for (Node node : graph.getAllNodes()) {
            if (node.getId().equals(nodeId))
                return node;
        }
        return null;
    }

    public int getMyPoint() {
        return myPoint;
    }

    public int getEnemyPoint() {
        return enemyPoint;
    }

    public int getTurn() {
        return turn;
    }

    public void doAction(Action action) {
        JsonObject payload = (JsonObject) Json.GSON.toJsonTree(action);
        Message msg = new Message("5", payload);
        sender.accept(msg);
    }

    public void initialize(ClientInitMessage msg) {
        myPoint = msg.getYourPoint();
        enemyPoint = msg.getEnemyPoint();
        turn = msg.getTurn();
        buildGraph(msg.getNodes(), msg.getEdges());
    }

    private void buildGraph(List<Node> nodes, HashMap<String, String> edges) {
        Graph graph = new Graph();
        graph.addNode(nodes);
        this.graph = graph;
        for (String nodeId : edges.keySet()) {
            Node sourceNode = getNodeWithId(nodeId);
            Node neighborNode = getNodeWithId(edges.get(nodeId));

            sourceNode.addNeighbor(neighborNode);
        }
    }
}
