package common.network.data;

/**
 * Message class.
 * This is the template of message from client to server
 */
public class Message {
    private int type;
    private Integer direction;
    private String message;
    private Integer value;

    public Message(int type) {
        this.type = type;
    }

    public Message(int type, Integer direction) {
        this.type = type;
        this.direction = direction;
    }

    public Message(int type, String message, int value) {
        this.type = type;
        this.message = message;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public Integer getDirection() {
        return direction;
    }

    public String getMessage() {
        return message;
    }

    public int getValue() {
        return value;
    }
}