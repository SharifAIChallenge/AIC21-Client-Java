package client.model;

import client.model.enums.ResourceType;

/**
 *object for the resources in the game
 */
public class Resource {
    private ResourceType type;
    private int value;

    public Resource(ResourceType type, int value) {
        this.type = type;
        this.value = value;
    }

    public ResourceType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
