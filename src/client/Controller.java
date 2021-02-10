package client;

import client.model.Answer;
import client.model.Game;
import client.model.dto.config.GameConfigMessage;
import client.model.dto.state.CurrentStateMessage;
import common.network.data.Message;
import common.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Main controller. Controls execution of the program, e.g. checks time limit of
 * the client, handles incoming messages, controls network operations, etc.
 * This is an internal implementation and you do not need to know anything about
 * this class.
 * Please do not change this class.
 */
public class Controller {
    // Logging tag
    private static final String TAG = "Controller";

    // File encoding for connection details
    private static String detailsEnc = "UTF-8";

    // Connection details
    private int port;
    private String host;
    private String token;
    private long retryDelay;

    // AI (participant's) class
    private AI ai;

    // Game model
    private Game game;

    // Client side network
    private client.Network network;

    // Terminator. Controller waits for this object to be notified. Then it will be terminated.
    private final Object terminator;

    // Network send function
    private Consumer<Message> sender;

    /**
     * Constructor
     *
     * @param hostIP     host address
     * @param hostPort   host port
     * @param token      client token
     * @param retryDelay connection retry delay
     */
    public Controller(String hostIP, int hostPort, String token, long retryDelay) {
        this.terminator = new Object();
        this.host = hostIP;
        this.port = hostPort;
        this.token = token;
        this.retryDelay = retryDelay;
    }


    /**
     * Starts a client by connecting to the server and sets game configuration .
     */
    public void start() {
        try {
            network = new client.Network(this::handleConfigurationMessage);
            sender = network::send;
            game = new Game();
            ai = new AI();

            network.setConnectionData(host, port, token);
            while (!network.isConnected()) {
                network.connect();
                Thread.sleep(retryDelay);
            }
            handleGame();
            synchronized (terminator) {
                terminator.wait();
            }
            network.terminate();
        } catch (Exception e) {
            Log.e(TAG, "Can not start the client.", e);
            e.printStackTrace();
        }
    }

    /**
     * Handles game configuration. This method will be called from
     * client.Network when network make connection to server
     *
     * @param configuration an object which have configuration data
     */
    private void handleConfigurationMessage(GameConfigMessage configuration) {
        game.initGameConfig(configuration);
    }


    /**
     * This method handle game, it will send an action
     * to server every 1 second
     */
    private void handleGame() {
        new Thread(() -> {
            handleTurn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleTurn() {
        Game newGame = new Game(game);// is this needed?!
        Message getState = new Message(0);
        sender.accept(getState);
        CurrentStateMessage stateMessage = null;
        try {
            stateMessage = network.receive(CurrentStateMessage.class);
        } catch (IOException e) {
            Log.e(TAG, "Can not get state message from server.");
            e.printStackTrace();
            return;
        }
        newGame.setCurrentState(stateMessage);
        Answer answer = ai.turn(newGame);
        sendAIAnswer(answer);
    }

    private void sendAIAnswer(Answer answer) {
        Message movementResponse = new Message(1, answer.getDirection().ordinal());
        sender.accept(movementResponse);

        if (answer.getMessage() != null) {
            Message chatResponse = new Message(2, answer.getMessage(), answer.getMessageValue());
            sender.accept(chatResponse);
        }
    }

    private void end(Game game, Map<Integer, Integer> scores) {
        ai.end(/*TODO*/);
    }

    private void sendEndMsg(Message message) {
        sender.accept(message);
    }

}