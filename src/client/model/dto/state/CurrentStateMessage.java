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
    private List<CellDTO> aroundCells;

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

    public List<CellDTO> getAroundCells() {
        return aroundCells;
    }

    /**
     * @return cell[][] which is a 2-D array of entire map, those cell that are visible,
     * have filled with appropriate cell object, others are null
     */
    public Cell[][] getVisibleCells(int height, int width) {
        Cell[][] cells = new Cell[width][height];
        if (aroundCells == null)
            return cells;
        for (CellDTO cellDTO : aroundCells) {
            //derive cell info and make an instance of it
            Cell cell = new Cell(cellDTO.getCellType(), cellDTO.getXCoordinate(), cellDTO.getYCoordinate(), cellDTO.getResource());
            for (AntDTO antDTO : cellDTO.getPresentAnts()) {
                Ant simpleAnt = new Ant(antDTO.getAntType(), antDTO.getAntTeam(), cell.getXCoordinate(), cell.getYCoordinate());
                cell.addAntToCell(simpleAnt);
            }

            //add created cell to cells[][]
            cells[cell.getXCoordinate()][cell.getYCoordinate()] = cell;
        }
        return cells;
    }
}
