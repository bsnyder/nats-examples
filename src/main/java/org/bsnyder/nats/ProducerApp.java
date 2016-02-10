package org.bsnyder.nats;

import org.bsnyder.nats.producer.SimpleMessageProducer;

public class ProducerApp {

    public static void main(String[] args) {
        new SimpleMessageProducer().sendMessages();
    }
}
