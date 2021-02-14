package client.model;

import java.util.ArrayList;
import java.util.List;

public class ChatBox {
    private List<Chat> allChats;

    public ChatBox(List<Chat> allChats) {
        this.allChats = allChats;
    }

    public List<Chat> getAllChatsOfTurn(int turnNumber) {
        List<Chat> chats = new ArrayList<>();
        for (Chat chat : allChats) {
            if (chat.getTurn() == turnNumber) {
                chats.add(chat);
            }
        }
        return chats;
    }

    public List<Chat> getAllChats() {
        return allChats;
    }
}
