package client.model;

import client.World;
import client.model.dto.config.GameConfigMessage;
import client.model.dto.state.AntDTO;
import client.model.dto.state.CellDTO;
import client.model.dto.state.CurrentStateMessage;
import client.model.enums.AntTeam;
import client.model.enums.AntType;

import java.util.List;

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
    private int baseX;
    private int baseY;
    private int healthKargar;
    private int healthSarbaaz;
    private int attackDistance;
    private int generateKargar;
    private int generateSarbaaz;
    private int rateDeathResource;

    public Game() {
    }

    public Game(Game game) {
        this.antType = game.getAntType();
        this.baseX = game.getBaseX();
        this.baseY = game.getBaseY();
        this.healthKargar = game.getHealthKargar();
        this.healthSarbaaz = game.getHealthSarbaaz();
        this.attackDistance = game.getAttackDistance();
        this.generateKargar = game.getGenerateKargar();
        this.generateSarbaaz = game.getGenerateSarbaaz();
        this.rateDeathResource = game.getRateDeathResource();
    }

    // general game config will add to game with this method
    public void initGameConfig(GameConfigMessage configMessage) {
        antType = configMessage.getAntType();
        baseX = configMessage.getBaseX();
        baseY = configMessage.getBaseY();
        healthKargar = configMessage.getHealthKargar();
        healthSarbaaz = configMessage.getHealthSarbaaz();
        attackDistance = configMessage.getAttackDistance();
        generateKargar = configMessage.getGenerateKargar();
        generateSarbaaz = configMessage.getGenerateSarbaaz();
        rateDeathResource = configMessage.getRateDeathResource();
    }

    // set current state of game, includes [ant] & [chatBox], other fields are
    // general info
    public void setCurrentState(CurrentStateMessage stateMessage) {
        chatBox = new ChatBox(stateMessage.getChats());
        ant = initialAntState(stateMessage);
    }

    // create Ant template from incoming message info
    private Ant initialAntState(CurrentStateMessage stateMessage) {
        List<CellDTO> cellsDTO = stateMessage.getAroundCells();
        Cell[] cells = new Cell[cellsDTO.size()];
        for (int i = 0; i < cellsDTO.size(); i++) {
            cells[i] = new Cell(cellsDTO.get(i).getCellType(),
                    cellsDTO.get(i).getXCoordinate(),
                    cellsDTO.get(i).getYCoordinate(),
                    cellsDTO.get(i).getResource());
            for (AntDTO antDTO : cellsDTO.get(i).getPresentAnts()) {
                Ant simpleAnt = new Ant(antDTO.getAntType(), antDTO.getAntTeam(),
                        cells[i].getXCoordinate(), cells[i].getYCoordinate());
                cells[i].addAntToCell(simpleAnt);
            }
        }
        Map map = new Map(cells, stateMessage.getCurrentX(), stateMessage.getCurrentY());

        return new Ant(antType, AntTeam.ALLIED, attackDistance, map, stateMessage);
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
