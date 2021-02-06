package client.model;

public class Chat {
    private String message;
    private int turn;

    public Chat(String message, int turn) {
        this.message = message;
        this.turn = turn;
    }

    public String getMessage() {
        return message;
    }

    public int getTurn() {
        return turn;
    }
}
