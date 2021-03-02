package client.model;

/**
 * a ChatBox consists of multiple chat objects. each Chat obj is a message sent from other agents of client's team.
 * text is the string of the message
 * turn represents the sending turn of the message
 */
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
