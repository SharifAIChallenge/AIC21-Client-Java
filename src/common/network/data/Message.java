package common.network.data;

import com.google.gson.JsonObject;


/**
 * Message class.
 */
public class Message {
    public final String type;
    public final JsonObject info;
    public int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    public String getType() {
        return this.type;
    }

    public JsonObject getInfo() {
        return this.info;
    }

    public Message(String type, JsonObject args, int turn) {
        this.type = type;
        this.info = args;
        this.turn = turn;
    }

    public Message(String type, JsonObject args) {
        this.type = type;
        this.info = args;
    }
}