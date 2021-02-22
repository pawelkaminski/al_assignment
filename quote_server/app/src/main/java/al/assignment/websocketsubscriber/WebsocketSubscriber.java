package al.assignment.websocketsubscriber;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.json.simple.JSONObject;

import al.assignment.utils.WebSocketQueue;


public class WebsocketSubscriber extends WebSocketClient {
    static final String COINBASE_URL = "wss://ws-feed.pro.coinbase.com/";
    String symbol;
    private final WebSocketQueue queue;

    public WebsocketSubscriber(String symbol, WebSocketQueue queue, Draft draft) {
        super(URI.create(WebsocketSubscriber.COINBASE_URL), draft);
        this.symbol = symbol;
        this.queue = queue;
    }

    public WebsocketSubscriber(String symbol, WebSocketQueue queue) {
        super(URI.create(WebsocketSubscriber.COINBASE_URL));
        this.symbol = symbol;
        this.queue = queue;
    }

    public String createOnSendMessage() {
        JSONObject obj=new JSONObject();
        obj.put("type","subscribe");
        obj.put("product_ids",Arrays.asList(this.symbol));
        obj.put("channels",Arrays.asList("full"));
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send(createOnSendMessage());
        System.out.println("new connection opened");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(ByteBuffer message) {
        System.out.println("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }

}