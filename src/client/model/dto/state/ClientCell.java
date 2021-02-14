package client.model.dto.state;

import client.model.Resource;
import client.model.enums.CellType;
import client.model.enums.ResourceType;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientCell {
    @SerializedName(value = "cell_x")
    private int xCoordinate;
    @SerializedName(value = "cell_y")
    private int yCoordinate;
    @SerializedName(value = "cell_type")
    private int cellType;
    @SerializedName(value = "resource_value")
    private int resourceValue;
    @SerializedName(value = "resource_type")
    private int resourceType;
    @SerializedName(value = "ants")
    private List<ClientAnt> presentAnts;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public CellType getCellType() {
        return CellType.values()[cellType];
    }

    public Resource getResource() {
        ResourceType rType = ResourceType.values()[resourceType];
        int value = resourceValue;
        return new Resource(rType, value);
    }

    public List<ClientAnt> getPresentAnts() {
        return presentAnts;
    }
}
