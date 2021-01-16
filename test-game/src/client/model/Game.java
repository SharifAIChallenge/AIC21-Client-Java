package client.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Graph graph;
    private int myPoint;
    private int enemyPoint;
    private int turn;

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

    public void attack(Node myNode, Node enemyNode) {
        //TODO
    }

    public void movePower(Node myNode, int power) {
        //TODO
    }


}
