package client.model;

import client.model.enums.Owner;

import java.util.ArrayList;

public class Node {
    private String id;
    private Owner owner;
    private int power;
    private ArrayList<Node> neighbors = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // return -1 if you don't have permission to access node power
    public int getPower() {
        if (owner != Owner.MINE) {
            return -1;
        }
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }
    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Node> neighbors) {
        this.neighbors = neighbors;
    }
}
