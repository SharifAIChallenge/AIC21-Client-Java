package client.model;

import client.model.dto.state.CurrentStateMessage;
import client.model.enums.AntTeam;
import client.model.enums.AntType;

public class Ant {
    private AntType type;
    private AntTeam team;
    private Resource currentResource;
    private int currentX;
    private int currentY;
    private int health;
    private Map visibleMap;
    // manhattan distance of ant's view
    private int attackDistance;

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
    }

    public Ant(AntType type, AntTeam team, int attackDistance, Map map, CurrentStateMessage state) {
        this.type = type;
        this.team = team;
        this.currentResource = state.getCurrentResource();
        this.currentX = state.getCurrentX();
        this.currentY = state.getCurrentY();
        this.health = state.getHealth();
        this.visibleMap = map;
        this.attackDistance = attackDistance;
    }

    public int getXCoordinate() {
        return currentX;
    }

    public int getYCoordinate() {
        return currentY;
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
}
