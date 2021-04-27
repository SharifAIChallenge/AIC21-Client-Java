package client.model;

import client.World;
import client.model.dto.config.GameConfigMessage;
import client.model.dto.state.CurrentStateMessage;
import client.model.enums.AntTeam;
import client.model.enums.AntType;

/**
 * current state info and general info of the game will save in a Game obj
 * clients must NOT change or use this class {@link client.AI#turn(World)} uses
 * World interface to access this data
 */
public class Game implements World {
    // current state info
    private Ant ant;
    private ChatBox chatBox;
    // general info of agent
    private AntType antType;
    private int mapWidth;
    private int mapHeight;
    private int baseX;
    private int baseY;
    private int healthKargar;
    private int healthSarbaaz;
    private int attackDistance;
    private int viewDistance;
    private int generateKargar;
    private int generateSarbaaz;
    private int rateDeathResource;
    private GameConfigMessage.BaseDTO[] bases;

    public Game() {
    }

    public Game(Game game) {
        this.antType = game.getAntType();
        this.mapWidth = game.getMapWidth();
        this.mapHeight = game.getMapHeight();
        this.baseX = game.getBaseX();
        this.baseY = game.getBaseY();
        this.healthKargar = game.getHealthKargar();
        this.healthSarbaaz = game.getHealthSarbaaz();
        this.attackDistance = game.getAttackDistance();
        this.generateKargar = game.getGenerateKargar();
        this.generateSarbaaz = game.getGenerateSarbaaz();
        this.rateDeathResource = game.getRateDeathResource();
        this.viewDistance = game.getViewDistance();
        this.bases = game.bases;
    }

    // general game config will add to game with this method
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
        this.viewDistance = configMessage.getViewDistance();
        this.bases = configMessage.getBases();
    }

    @Override
    public GameConfigMessage.BaseDTO[] getBases() {
        return this.bases;
    }

    // set current state of game, includes [ant] & [chatBox], other fields are
    // general info
    public void setCurrentState(CurrentStateMessage stateMessage) {
        chatBox = new ChatBox(stateMessage.getChats());
        ant = initialAntState(stateMessage);
    }

    // create Ant template from incoming message info
    private Ant initialAntState(CurrentStateMessage stateMessage) {
        Cell[][] cells = stateMessage.getVisibleCells(mapHeight, mapWidth);
        Map map = new Map(cells, mapWidth, mapHeight, stateMessage.getCurrentX(), stateMessage.getCurrentY());

        return new Ant(antType, AntTeam.ALLIED, attackDistance, map, stateMessage, viewDistance);
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public Ant getAnt() {
        return ant;
    }

    public AntType getAntType() {
        return antType;
    }

    public ChatBox getChatBox() {
        return chatBox;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getBaseX() {
        return baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public int getHealthKargar() {
        return healthKargar;
    }

    public int getHealthSarbaaz() {
        return healthSarbaaz;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    public int getGenerateKargar() {
        return generateKargar;
    }

    public int getGenerateSarbaaz() {
        return generateSarbaaz;
    }

    public int getRateDeathResource() {
        return rateDeathResource;
    }
}
