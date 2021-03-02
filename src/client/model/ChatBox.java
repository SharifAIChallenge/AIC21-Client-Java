package client.model;

import client.World;

import java.util.ArrayList;
import java.util.List;

/**
 * list of all chats from the client's agents.
 * each element is a {@link Chat}
 * you can access your chatbox each turn, by the {@link client.World} obj on {@link client.AI#turn(World)}}
 */
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
