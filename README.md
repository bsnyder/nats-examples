# NATS Examples

This project contains some examples of using the NATS Java client to connect to the [NATS message broker](http://nats.io/).

### Running the Examples
These examples are intended to be run from the terminal using Maven. Run the
NATS message broker in one terminal window, the consumer in second terminal
window and the producer in a third terminal window. This way you can see NATS
output while watching the output from both the consumer and the producer.

## Asynchronous Consumption
With asynchronous message consumption, message producers have no knowledge of message consumers and vice versa. Producers can send messages to the message broker without any dependency on the consumer (i.e., the consumer need not be present when the messages are sent to the message broker). Furthermore, a message handler is registered with the message broker for a given subscription allowing the message broker to invoke the message handler for every message that is received to the subscription. This first set of examples demonstrates asychronous message consumption. See the `SimpleAsyncMessageConsumer` for the details.

#### Terminal One 
In terminal one, run NATS:

```
$ cd $NATS_HOME
$ ./gnatsd
[13527] 2016/02/10 20:27:51.837710 [INF] Starting gnatsd version 0.7.2
[13527] 2016/02/10 20:27:51.839904 [INF] Listening for client connections on 0.0.0.0:4222
[13527] 2016/02/10 20:27:51.841600 [INF] gnatsd is ready
```

#### Terminal Two
In terminal two, start the asynchronous consumer (note the argument to specify the consumerType):

```
$ mvn -Pconsumer exec:java -DconsumerType=async
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml (2 KB at 0.5 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
DEBUG - ConsumerApp                    - Using the 'async' consumer type
DEBUG - ConsumerApp                    - Starting up the SimpleAsyncMessageConsumer
```

#### Terminal Three
In terminal three, run the producer:

```
$ mvn -Pproducer exec:java
[INFO] Scanning for projects...
[INFO]
[INFO]
------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO]
------------------------------------------------------------------------
Downloading:
https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded:
https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
(3 KB at 1.9 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
INFO  - SimpleMessageProducer          - Sent message number 0
INFO  - SimpleMessageProducer          - Sent message number 1
INFO  - SimpleMessageProducer          - Sent message number 2
INFO  - SimpleMessageProducer          - Sent message number 3
INFO  - SimpleMessageProducer          - Sent message number 4
INFO  - SimpleMessageProducer          - Sent message number 5
INFO  - SimpleMessageProducer          - Sent message number 6
INFO  - SimpleMessageProducer          - Sent message number 7
INFO  - SimpleMessageProducer          - Sent message number 8
INFO  - SimpleMessageProducer          - Sent message number 9
```

## Results
Running the producer results in the consumer receiving the messages in an asynchronous manner. You should see the following output from the consumer indicating that it has consumed the 10 messages that are sent by default:

```
$ mvn -Pconsumer exec:java -DconsumerType=async[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml (2 KB at 0.5 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
DEBUG - ConsumerApp                    - Using the 'async' consumer type
DEBUG - ConsumerApp                    - Starting up the SimpleAsyncMessageConsumer
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '0' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '1' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '2' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '3' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '4' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '5' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '6' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '7' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '8' Tue Feb 16 22:58:17 MST 2016
INFO  - SimpleAsyncMessageConsumer     - Received message: Hello NATS! '9' Tue Feb 16 22:58:17 MST 2016
```


## Synchronous Consumption
With synchronous message consumption, the message consumer polls the message broker to wait for a message to received either indefinitely (using the `nextMessage()` method with no timeout) or for a specified amount of time (using the the `nextMessage(int timeout)` method with a timeout). This second set of exmaples demonstrates sychronous message consumption. See the `SimpleSyncMessageConsumer` for the details.

#### Terminal One 
In terminal one, run NATS:

```
$ cd $NATS_HOME
$ ./gnatsd
[13527] 2016/02/10 20:27:51.837710 [INF] Starting gnatsd version 0.7.2
[13527] 2016/02/10 20:27:51.839904 [INF] Listening for client connections on 0.0.0.0:4222
[13527] 2016/02/10 20:27:51.841600 [INF] gnatsd is ready
```

#### Terminal Two
In terminal two, start the synchronous consumer (note the argument to specify the consumerType):

```
$ mvn -Pconsumer exec:java -DconsumerType=sync
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml (2 KB at 1.1 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
DEBUG - ConsumerApp                    - Using the 'sync' consumer type
DEBUG - ConsumerApp                    - Starting up the SimpleSyncMessageConsumer
```


#### Terminal Three
In terminal three, run the producer:

```
$ mvn -Pproducer exec:java
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml (2 KB at 0.7 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
INFO  - SimpleMessageProducer          - Sent message number 0
INFO  - SimpleMessageProducer          - Sent message number 1
INFO  - SimpleMessageProducer          - Sent message number 2
INFO  - SimpleMessageProducer          - Sent message number 3
INFO  - SimpleMessageProducer          - Sent message number 4
INFO  - SimpleMessageProducer          - Sent message number 5
INFO  - SimpleMessageProducer          - Sent message number 6
INFO  - SimpleMessageProducer          - Sent message number 7
INFO  - SimpleMessageProducer          - Sent message number 8
INFO  - SimpleMessageProducer          - Sent message number 9
```

## Results
Running the producer results in the consumer receiving the messages in a 
synchronous manner. You should see the following output from the consumer indicating that 
it has consumed the 10 messages that are sent by default:

```
$ mvn -Pconsumer exec:java -DconsumerType=sync
[INFO] Scanning for projects...
[INFO]
[INFO]
------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO]
------------------------------------------------------------------------
Downloading:
https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded:
https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
(2 KB at 1.1 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
DEBUG - ConsumerApp                    - Using the 'sync' consumer type
DEBUG - ConsumerApp                    - Starting up the
SimpleSyncMessageConsumer
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '0' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '1' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '2' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '3' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '4' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '5' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '6' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '7' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '8' Tue
Feb 16 22:52:11 MST 2016
INFO  - SimpleSyncMessageConsumer      - Received message: Hello NATS! '9' Tue
Feb 16 22:52:11 MST 2016
```

## TODO
There's plenty more to demonstrate using NATS and over time I hope to do so. Check back often ;-).
