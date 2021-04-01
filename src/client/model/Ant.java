package client.model;

import client.model.dto.state.AttackDTO;
import client.model.dto.state.CurrentStateMessage;
import client.model.enums.AntTeam;
import client.model.enums.AntType;

import java.util.ArrayList;
import java.util.List;

public class Ant {
    private AntType type;
    private AntTeam team;
    private Resource currentResource;
    private int currentX;
    private int currentY;
    private int health;
    private Map visibleMap;
    private int attackDistance;
    private int viewDistance;
    private List<AttackDTO> attacks;

    public Ant(AntType type, AntTeam team, int currentX, int currentY) {
        this.type = type;
        this.team = team;
        this.currentX = currentX;
        this.currentY = currentY;
        //below data are not valid
        this.currentResource = null;
        this.visibleMap = null;
        this.health = -1;
        this.attackDistance = -1;
        this.viewDistance = -1;
        this.attacks = new ArrayList<>();
    }

    public Ant(AntType type, AntTeam team, int attackDistance, Map map, CurrentStateMessage state, int viewDistance) {
        this.type = type;
        this.team = team;
        this.currentResource = state.getCurrentResource();
        this.currentX = state.getCurrentX();
        this.currentY = state.getCurrentY();
        this.health = state.getHealth();
        this.visibleMap = map;
        this.attackDistance = attackDistance;
        this.viewDistance = viewDistance;
        this.attacks = state.getAttacks();
    }

    public List<AttackDTO> getAttacks() {
        return attacks;
    }

    private Cell getMapRelativeCell(int xStep, int yStep) {
        return visibleMap.getRelativeCell(xStep, yStep);
    }

    public Cell getNeighborCell(int xStep, int yStep) {
        return getMapRelativeCell(xStep, yStep);
    }

    public int getXCoordinate() {
        return currentX;
    }

    public int getYCoordinate() {
        return currentY;
    }

    public Cell getLocationCell() {
        return getNeighborCell(0, 0);
    }

    public AntType getType() {
        return type;
    }

    public AntTeam getTeam() {
        return team;
    }

    public Resource getCurrentResource() {
        return currentResource;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDistance() {
        return attackDistance;
    }


    public Map getVisibleMap() {
        return visibleMap;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getViewDistance() {
        return viewDistance;
    }
}