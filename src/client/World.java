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
     * AntType is an enum {@link AntType}
     */
    public AntType getAntType();

    /**
     * @return your chat box
     * AntType is an enum {@link client.model.ChatBox}
     * you can access every chat message {@link client.model.Chat} using ChatBox
     */
    public ChatBox getChatBox();

    /**
     * @return map's width
     */
    public int getMapWidth();

    /**
     * @return map's height
     */
    public int getMapHeight();

    /**
     * @return X coordinate of the team's base
     */
    public int getBaseX();

    /**
     * @return Y coordinate of the team's base
     */
    public int getBaseY();

    /**
     * @return early health of a ant which is {@link AntType#KARGAR}
     */
    public int getHealthKargar();

    /**
     * @return early health of a ant which is {@link AntType#SARBAAZ}
     */
    public int getHealthSarbaaz();

    /**
     * @return maximum Manhattan distance of a target
     */
    public int getAttackDistance();

    /**
     * @return Bread needed to generate one Kargar  (GenerateKargar)
     */
    public int getGenerateKargar();

    /**
     * @return Grass needed to generate one sarbaaz (GenerateSarbaaz)
     */
    public int getGenerateSarbaaz();

    /**
     * @return RateDeathResource
     */
    public int getRateDeathResource();
}
