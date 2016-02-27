package org.bsnyder.nats.sync;

import io.nats.client.Connection;
import io.nats.client.ConnectionFactory;
import io.nats.client.Message;
import io.nats.client.Subscription;
import io.nats.client.SyncSubscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleSyncMessageConsumer {

    private final static Logger LOG = LoggerFactory.getLogger(SimpleSyncMessageConsumer.class);

    public void receiveMessages(int numberOfMessages, String queueName) {
        ConnectionFactory factory = new ConnectionFactory(ConnectionFactory.DEFAULT_URL);
        Connection connection = null;
        Subscription subscription = null;

        try {
            connection = factory.createConnection();
            subscription = connection.subscribeSync(queueName);

            for (int i = 0; i < numberOfMessages; ++i) {
                Message message = ((SyncSubscription) subscription).nextMessage();
                LOG.info("Received message: {}", new String(message.getData()));
            }

            ((SyncSubscription)subscription).unsubscribe();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
