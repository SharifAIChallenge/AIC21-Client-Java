package client.model;

import client.model.enums.AntTeam;
import client.model.enums.AntType;

public class Ant {
    private AntType type;
    private AntTeam team;
    private Resource carryingResource;
    private Base baseInfo;
    private int health;
    private Map visibleMap;
    // manhatan distance of ant's view
    private int viewDistance;

    public void doAction() {
        //TODO
    }

    public void chat() {
        //TODO
    }

    private Cell getMapCell(int xStep, int yStep) {
        return visibleMap.getCell(xStep, yStep, viewDistance);
    }

    public Cell getNeighborCell(int xStep, int yStep) {
        return getMapCell(xStep, yStep);
    }

    public int getXCoordinate() {
        Cell currentCell = getNeighborCell(0, 0);
        return currentCell.getXCoordinate();
    }

    public int getYCoordinate() {
        Cell currentCell = getNeighborCell(0, 0);
        return currentCell.getYCoordinate();
    }

    public Cell getCurrentCell() {
        return getNeighborCell(0, 0);
    }

    public AntType getType() {
        return type;
    }

    public AntTeam getTeam() {
        return team;
    }

    public Resource getCarryingResource() {
        return carryingResource;
    }

    public Base getBaseInfo() {
        return baseInfo;
    }

    public int getHealth() {
        return health;
    }

    public int getViewDistance() {
        return viewDistance;
    }
}

// TODO: CurrentState --> before AI call
// GameConfig           --> at startup
