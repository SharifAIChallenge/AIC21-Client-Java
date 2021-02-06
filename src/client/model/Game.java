package client.model;

import client.model.dto.config.GameConfigMessage;
import client.model.dto.state.CurrentStateMessage;
import client.model.enums.AntTeam;
import client.model.enums.AntType;
import common.network.data.Message;

import java.util.function.Consumer;

public class Game {
    private Ant ant;
    private AntType antType;
    private ChatBox chatBox;
    private int mapWidth;
    private int mapHeight;
    private int baseX;
    private int baseY;
    private int healthKargar;
    private int healthSarbaaz;
    private int attackDistance;
    private int generateKargar;
    private int generateSarbaaz;
    private int rateDeathResource;

    //sender
    private Consumer<Message> sender;

    public Game(Consumer<Message> sender) {
        this.sender = sender;
    }

    public Game(Game game) {
        //copy game info
    }

    public void doAction() {
        //TODO
    }

    public void chat() {
        //TODO
    }

    //general game config will add to game with this method
    public void initGameConfig(GameConfigMessage configMessage) {
        antType = configMessage.getAntType();
        mapWidth = configMessage.getMapWidth();
        mapHeight = configMessage.getMapHeight();
        baseX = configMessage.getBaseX();
        baseY = configMessage.getBaseY();
        healthKargar = configMessage.getHealthKargar();
        healthSarbaaz = configMessage.getHealthSarbaaz();
        attackDistance = configMessage.getAttackDistance();
        generateKargar = configMessage.getGenerateKargar();
        generateSarbaaz = configMessage.getGenerateSarbaaz();
        rateDeathResource = configMessage.getRateDeathResource();
    }

    //set current state of game, includes [ant] & [chatBox], other fields are general info
    public void setCurrentState(CurrentStateMessage stateMessage) {
        chatBox = new ChatBox(stateMessage.getChats());
        ant = initialAntState(stateMessage);
    }

    //create Ant template from incoming message info
    private Ant initialAntState(CurrentStateMessage stateMessage) {
        Cell[][] cells = stateMessage.getVisibleCells(mapHeight, mapWidth);
        Map map = new Map(cells, mapWidth, mapHeight, attackDistance, stateMessage.getCurrentX(), stateMessage.getCurrentY());

        return new Ant(antType, AntTeam.ALLIED, attackDistance, map, stateMessage);
    }
}
