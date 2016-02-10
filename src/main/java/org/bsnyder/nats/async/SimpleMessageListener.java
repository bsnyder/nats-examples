package org.bsnyder.nats.async;

import io.nats.client.Connection;
import io.nats.client.ConnectionFactory;
import io.nats.client.Message;
import io.nats.client.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleMessageListener implements MessageHandler {

    private final static Logger LOG = LoggerFactory.getLogger(SimpleMessageListener.class);

    public void receiveMessages() {
        ConnectionFactory factory = new ConnectionFactory(ConnectionFactory.DEFAULT_URL);
        Connection connection;

        try {
            connection = factory.createConnection();
            connection.subscribeAsync("foo", this);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(Message msg) {
        LOG.info("Received message: {}", new String(msg.getData()));
    }

}
