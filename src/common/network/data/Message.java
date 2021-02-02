package common.network.data;

import com.google.gson.JsonObject;


/**
 * Message class.
 */
public class Message {
    public final String type;
    public final JsonObject payload;
    public final String token;

    public Message(String type, JsonObject args, String token) {
        this.type = type;
        this.payload = args;
        this.token = token;
    }
}