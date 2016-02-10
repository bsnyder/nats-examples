package org.bsnyder.nats.producer;

import io.nats.client.Connection;
import io.nats.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class SimpleMessageProducer {

    private final static Logger LOG = LoggerFactory.getLogger(SimpleMessageProducer.class);

    protected int numberOfMessages = 10;

    public void sendMessages() {
        ConnectionFactory factory = new ConnectionFactory(ConnectionFactory.DEFAULT_URL);
        Connection connection;

        try {
            connection = factory.createConnection();
            StringBuilder buffer;

            for (int i = 0; i < numberOfMessages; ++i) {
                buffer = new StringBuilder();
                buffer.append("Hello NATS! '").append(i).append("' ").append(new Date());
                connection.publish("foo", buffer.toString().getBytes());
                LOG.info("Sent message number {}", i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
