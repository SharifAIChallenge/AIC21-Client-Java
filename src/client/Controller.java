package client;

import client.model.Answer;
import client.model.Game;
import client.model.dto.config.GameConfigMessage;
import client.model.dto.state.CurrentStateMessage;
import com.google.gson.JsonObject;
import common.network.Json;
import common.network.data.Message;
import common.util.Log;

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
     * Starts a client by connecting to the server and sending a token.
     */
    public void start() {
        try {
            network = new client.Network(this::handleMessage);
            sender = network::send;
            game = new Game(sender);
            ai = new AI();

            network.setConnectionData(host, port, token);
            while (!network.isConnected()) {
                network.connect();
                Thread.sleep(retryDelay);
            }
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
     * Handles incoming message. This method will be called from
     * client.Network  when a new message is received.
     *
     * @param msg incoming message
     */
    private void handleMessage(Message msg) {
        Log.v(TAG, msg.type + " received.");
        switch (msg.type) {     //must be coordinated between client and server
            case "init":
                handleInitMessage(msg);
                break;
            case "turn":
                handleTurnMessage(msg);
                break;
            case "around_cells":
                handleMapMessage(msg);
            case "shutdown":
                handleShutdownMessage(msg);
                break;
            default:
                Log.w(TAG, "Undefined message received: " + msg.type);
                break;
        }
        Log.v(TAG, msg.type + " handle finished.");
    }

    private void handleMapMessage(Message msg) {
        Game newGame = new Game(game);
        CurrentStateMessage currentStateMessage = Json.GSON.fromJson(msg.getInfo(), CurrentStateMessage.class);
        newGame.setCurrentState(currentStateMessage);
        Message endMsg1 = new Message("1", new JsonObject());
        Message endMsg2 = new Message("2", new JsonObject());
        turn(newGame, endMsg1, endMsg2);
    }

    /**
     * Handles init message.
     *
     * @param msg init message
     */
    private void handleInitMessage(Message msg) {
        GameConfigMessage gameConfigMessage = Json.GSON.fromJson(msg.getInfo(), GameConfigMessage.class);
        game.initGameConfig(gameConfigMessage);
        //maybe we need to send a message to the server
    }

    private void handleTurnMessage(Message msg) {
        Message endMsg = new Message("0", new JsonObject());
        sendEndMsg(endMsg);
    }

    /**
     * Handles shutdown message.
     *
     * @param msg shutdown message
     */
    private void handleShutdownMessage(Message msg) {
        Game newGame = new Game(game);
        //...
        network.terminate();
        System.exit(0);
    }

    private void turn(Game game, Message msg1, Message msg2) {
        new Thread(() ->
        {
            try {
                Answer answer = ai.turn(game);
                int direction;
                switch (answer.getDirection()) {
                    case CENTER:
                        direction = 0;
                        break;
                    case UP:
                        direction = 2;
                        break;
                    case DOWN:
                        direction = 4;
                        break;
                    case RIGHT:
                        direction = 1;
                        break;
                    case LEFT:
                        direction = 3;
                        break;
                    default:
                        direction = 0;
                }
                msg1.info.addProperty("direction", direction);
                msg2.info.addProperty("message", answer.getMessage());
                msg2.info.addProperty("value", answer.getMessageValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
            sendEndMsg(msg1);
            sendEndMsg(msg2);
        }).start();
    }

    private void end(Game game, Map<Integer, Integer> scores) {
        ai.end(/*TODO*/);
    }

    private void sendEndMsg(Message message) {
        sender.accept(message);
    }

}