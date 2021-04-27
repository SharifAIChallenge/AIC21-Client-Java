package client;

import client.model.Ant;
import client.model.ChatBox;
import client.model.dto.config.GameConfigMessage;
import client.model.enums.AntType;

public interface World {
    int MAX_MESSAGE_LENGTH = 1000;

    /**
     * @return your ant object  {@link client.model.Ant}
     */
    public Ant getAnt();

    public GameConfigMessage.BaseDTO[] getBases();

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
     * @return early health of a ant which is {@link AntType#QUEEN}
     */
    public int getHealthQueen();

    /**
     * @return early health of a ant which is {@link AntType#SCORPION}
     */
    public int getHealthScorpion();

    /**
     * @return maximum Manhattan distance of a target
     */
    public int getAttackDistance();

    /**
     * @return Bread needed to generate one Queen  (GenerateQueen)
     */
    public int getGenerateQueen();

    /**
     * @return Grass needed to generate one sarbaaz (GenerateSarbaaz)
     */
    public int getGenerateScorpion();

    /**
     * @return RateDeathResource
     */
    public int getRateDeathResource();
}
