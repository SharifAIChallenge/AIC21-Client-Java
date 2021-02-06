package client.model;

import client.model.enums.CellType;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private CellType type;
    private int xCoordinate;
    private int yCoordinate;
    private Resource resource;
    //TODO -> one agent must not have this authority to use other agents, must just know [team] and [type]
    private Set<Ant> presentAnts;

    public Cell(CellType type, int xCoordinate, int yCoordinate, Resource resource) {
        this.type = type;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.resource = resource;
        this.presentAnts = new HashSet<>();
    }

    public void addAntToCell(Ant ant) {
        presentAnts.add(ant);
    }

    public CellType getType() {
        return type;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public Resource getResource() {
        return resource;
    }

    public Set<Ant> getPresentAnts() {
        return presentAnts;
    }
}
