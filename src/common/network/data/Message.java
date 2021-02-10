package common.network.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import common.network.Json;


/**
 * Message class.
 */
public class Message
{
    public final String type;
    public final JsonObject info;
    public int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }


    public String getType(){
        return this.type;
    }

    public JsonObject getInfo(){
        return this.info;
    }

    public Message(String type, JsonObject info) {
        this.type = type;
        this.info = info;
    }

    public Message(String type, JsonObject args, int turn)
    {
        this.type = type;
        this.info = args;
        this.turn = turn;
    }
}