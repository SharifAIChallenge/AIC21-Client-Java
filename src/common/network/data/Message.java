package common.network.data;

import com.google.gson.JsonObject;


/**
 * Message class.
 */
public class Message {
    public final String type;
    public final JsonObject payload;
    public String token;

    public Message(String type, JsonObject args) {
        this.type = type;
        this.payload = args;
    }

    public void setToken(String token) {
        this.token = token;
    }
}