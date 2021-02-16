package client.model;

import client.model.enums.Direction;

public class Answer {
    private Direction direction;
    private String message;
    private int messageValue;

    public Answer(Direction direction, String message, int messageValue) {
        this.direction = direction;
        this.message = message;
        this.messageValue = messageValue;
    }

    public Answer(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(int messageValue) {
        this.messageValue = messageValue;
    }
}
