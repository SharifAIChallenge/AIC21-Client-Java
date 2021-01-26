package client.model;

import client.model.enums.ActionType;

public class Action {
    private ActionType type;
    private Node sourceNode;
    private Node targetNode;

    public Action(ActionType type) {
        this.type = type;
    }

    public Action(ActionType type, Node sNode, Node tNode) {
        this.type = type;
        sourceNode = sNode;
        targetNode = tNode;
    }

    public ActionType getType() {
        return type;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }
}
