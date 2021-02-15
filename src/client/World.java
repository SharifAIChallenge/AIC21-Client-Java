package client;

import client.model.Ant;
import client.model.ChatBox;
import client.model.enums.AntType;
import client.model.enums.Direction;

public interface World {
    public void sendDirection(Direction direction);

    public void sendMessage(String message, int value);

    public Ant getAnt();

    public AntType getAntType();

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
