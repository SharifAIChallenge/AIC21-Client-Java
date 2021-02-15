package client;

import client.model.Ant;
import client.model.ChatBox;
import client.model.enums.AntType;
import client.model.enums.Direction;

public interface World {
    int MAX_MESSAGE_LENGTH = 1000;

    /**
     * use this method for choosing your moving direction
     *
     * @param direction is an enum object (UP, DOWN, LEFT, RIGHT, CENTER)
     * you can access different direction using  {@link client.model.enums.Direction}
     */
    public void chooseDirection(Direction direction);

    /**
     * use this method for sending you message and its value
     * you can only send one message in each turn
     * your message length must be smaller than or equal to {@link #MAX_MESSAGE_LENGTH}
     *
     * @param message is your message text
     * @param value   is your message value
     */
    public void sendMessage(String message, int value);

    /**
     * @return your ant object  {@link client.model.Ant}
     */
    public Ant getAnt();

    /**
     * @return your ant type
     * AntType is an enum {@link client.model.enums.AntType}
     */
    public AntType getAntType();

    /**
     * @return your chat box
     * AntType is an enum {@link client.model.ChatBox}
     * you can access every chat message {@link client.model.Chat} using ChatBox
     */
    public ChatBox getChatBox();

    public int getMapWidth();

    public int getMapHeight();

    public int getBaseX();

    public int getBaseY();

    public int getHealthKargar();

    public int getHealthSarbaaz();

    public int getAttackDistance();

    public int getGenerateKargar();

    public int getGenerateSarbaaz();

    public int getRateDeathResource();
}
