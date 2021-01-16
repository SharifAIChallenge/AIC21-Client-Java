package client.model;

import client.model.enums.ActionType;

public class Action {
    private ActionType type;
    private Node sourceNode;
    private Node destinationNode;

    public Action(ActionType type) {
        this.type = type;
    }

    public Action(ActionType type, Node sNode, Node tNode) {
        this.type = type;
        sourceNode = sNode;
        destinationNode = tNode;
    }

    public ActionType getType() {
        return type;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public Node getDestinationNode() {
        return destinationNode;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public void setDestinationNode(Node destinationNode) {
        this.destinationNode = destinationNode;
    }
}
