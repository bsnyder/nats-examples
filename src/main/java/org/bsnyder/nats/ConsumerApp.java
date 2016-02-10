package org.bsnyder.nats;

import org.bsnyder.nats.async.SimpleMessageListener;

public class ConsumerApp {

    public static void main(String[] args) {
        new SimpleMessageListener().receiveMessages();
    }
}
