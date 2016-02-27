package org.bsnyder.nats.async;

import io.nats.client.AsyncSubscription;
import io.nats.client.Connection;
import io.nats.client.ConnectionFactory;
import io.nats.client.Message;
import io.nats.client.MessageHandler;
import io.nats.client.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleAsyncMessageConsumer implements MessageHandler {

    private final static Logger LOG = LoggerFactory.getLogger(SimpleAsyncMessageConsumer.class);

    public void receiveMessages(int numberOfMessages, String queueName) {
        ConnectionFactory factory = new ConnectionFactory(ConnectionFactory.DEFAULT_URL);
        Connection connection = null;
        Subscription subscription = null;

        try {
            connection = factory.createConnection();
            subscription = connection.subscribeAsync(queueName, this);

            if (numberOfMessages > 0) {
                ((AsyncSubscription) subscription).autoUnsubscribe(numberOfMessages);
            }

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
