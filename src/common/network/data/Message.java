package common.network.data;

import com.google.gson.JsonObject;

public class Message {

    private String type;
    // payload = info
    private JsonObject info;

    public Message(String type, JsonObject info) {
        this.type = type;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonObject getInfo() {
        return info;
    }

    public void setInfo(JsonObject info) {
        this.info = info;
    }
}