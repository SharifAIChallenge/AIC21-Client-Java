package client.model;

public class Chat {
    private String text;
    private int turn;

    public Chat(String text, int turn) {
        this.text = text;
        this.turn = turn;
    }

    public String getText() {
        return text;
    }

    public int getTurn() {
        return turn;
    }
}
