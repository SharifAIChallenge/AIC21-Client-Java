package client.model.dto.state;

import client.model.Ant;
import client.model.Cell;
import client.model.Chat;
import client.model.Resource;
import client.model.enums.ResourceType;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * accessible data for current agent will save in this class (the data that sent from the server via Json)
 * clients must NOT change or use this class
 */
public class CurrentStateMessage {
    @SerializedName(value = "current_x")
    private int currentX;
    @SerializedName(value = "current_y")
    private int currentY;
    @SerializedName(value = "current_resource_value")
    private int currentResourceValue;
    @SerializedName(value = "current_resource_type")
    private int currentResourceType;
    @SerializedName(value = "health")
    private int health;
    @SerializedName(value = "chat_box")
    private List<Chat> chats;
    @SerializedName(value = "around_cells")
    private List<ClientCell> aroundCells;

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public Resource getCurrentResource() {
        int value = currentResourceValue;
        ResourceType rType = ResourceType.values()[currentResourceType];
        return new Resource(rType, value);
    }

    public int getHealth() {
        return health;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public List<ClientCell> getAroundCells() {
        return aroundCells;
    }

    /*
     * @return cell[][] which is a 2-D array of entire map, those cell that are visible,
     * have filled with appropriate cell object, others are null
     */
    public Cell[][] getVisibleCells(int height, int width) {
        Cell[][] cells = new Cell[height][width];
        if (aroundCells == null)
            return cells;
        for (ClientCell clientCell : aroundCells) {
            //derive cell info and make an instance of it
            Cell cell = new Cell(clientCell.getCellType(), clientCell.getYCoordinate(), clientCell.getYCoordinate(), clientCell.getResource());
            for (ClientAnt clientAnt : clientCell.getPresentAnts()) {
                //TODO if we decide to change Cell.presentAnts<Ant>, we should change it here
                Ant simpleAnt = new Ant(clientAnt.getAntType(), clientAnt.getAntTeam());
                cell.addAntToCell(simpleAnt);
            }

            //add created cell to cells[][]
            cells[cell.getYCoordinate()][cell.getXCoordinate()] = cell;
        }
        return cells;
    }
}
