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
}
