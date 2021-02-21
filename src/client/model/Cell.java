package client.model;

import client.model.enums.CellType;

import java.util.HashSet;
import java.util.Set;

/**
 * one cell of the map
 * you can access map cells using {@link client.model.Map}
 * X for horizontal coordinate
 * Y for vertical coordinates
 */
public class Cell {
    private CellType type;
    private int x;
    private int y;
    private Resource resource;
    //TODO -> one agent must not have this authority to use other agents, must just know [team] and [type]
    private Set<Ant> ants;

    public Cell(CellType type, int x, int y, Resource resource) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.resource = resource;
        this.ants = new HashSet<>();
    }

    public void addAntToCell(Ant ant) {
        ants.add(ant);
    }

    public CellType getType() {
        return type;
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public Resource getResource() {
        return resource;
    }

    public Set<Ant> getAnts() {
        return ants;
    }
}
