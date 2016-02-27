package org.bsnyder.nats;

import org.bsnyder.nats.async.SimpleAsyncMessageConsumer;
import org.bsnyder.nats.sync.SimpleSyncMessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerApp {

    private final static Logger LOG = LoggerFactory.getLogger(ConsumerApp.class);

    public static void main(String[] args) {

        int numberOfMessages = 10;
        String queueName = "foo";
        String consumerType = null;

        if (args.length > 0 && null != args[0] && !"".equals(args[0])) {
            consumerType = args[0];
        }

        LOG.debug("Using the '{}' consumer type", consumerType);

        if ("async".equals(consumerType)) {
            LOG.debug("Starting up the SimpleAsyncMessageConsumer");
            new SimpleAsyncMessageConsumer().receiveMessages(numberOfMessages, queueName);
        } else if ("sync".equals(consumerType)) {
            LOG.debug("Starting up the SimpleSyncMessageConsumer");
            new SimpleSyncMessageConsumer().receiveMessages(numberOfMessages, queueName);
        }
    }
}
