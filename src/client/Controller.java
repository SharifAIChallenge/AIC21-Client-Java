package client;

import client.dto.ClientInitMessage;
import client.model.Game;
import common.network.Json;
import common.network.data.Message;
import common.util.Log;

import java.util.function.Consumer;

public class Controller {
    private static final String TAG = "Controller";

    private int port;
    private String host;
    private String token;
    private long retryDelay;

    private final Object terminator;

    private Consumer<Message> sender;
    private Network network;
    private Game game;
    private AI ai;

    public Controller(int port, String host, String token, long retryDelay) {
        this.terminator = new Object();
        this.port = port;
        this.host = host;
        this.token = token;
        this.retryDelay = retryDelay;
    }

    public void run() {
        try {
            network = new Network(this::handleMessage);
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
            Log.e(TAG, "Can not start client :(.", e);
            e.printStackTrace();
        }
    }

    public void handleMessage(Message msg) {
        Log.v(TAG, msg.type + " received.");
        switch(msg.type) {
            //handel game info
            case "4":
                handleInitMessage(msg);
                break;
            //handle turn message
            case "6":
                handleTurnMessage(msg);
                break;
            //handle server response
            case "8":
            case "10":
                handleResponseMessage(msg);
                break;
            //handle undefined messages
            default:
                Log.w(TAG, "Undefined message received: " + msg.type);
                break;
        }
        Log.v(TAG, msg.type + " handle finished.");
    }

    public void handleInitMessage(Message msg) {
        String gameInfo = msg.payload.toString();
        ClientInitMessage initMessage = Json.GSON.fromJson(gameInfo, ClientInitMessage.class);
        game.initialize(initMessage);
    }

    public void handleTurnMessage(Message msg) {
        handleInitMessage(msg);

        new Thread(() -> ai.doTurn(game)).start();
    }

    public void handleResponseMessage(Message msg) {
        if (msg.type.equals("8")) {
            String result = msg.payload.toString();
            System.err.println(result);
        } else {
            System.out.println("your action was successful!");
        }
    }

    public void sendEndMessage(Message msg) {
        sender.accept(msg);
    }
}
