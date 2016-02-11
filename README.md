# NATS Examples

Some examples of using the NATS Java client to connect to the [NATS message broker](http://nats.io/).

## Running the Examples
These examples are intended to be run from the terminal using Maven. Run the
NATS message broker in one terminal window, the consumer in second terminal
window and the producer in a third terminal window. This way you can see NATS
output while watching the output from both the consumer and the producer.

### Terminal One 
In terminal one, run NATS:

```
$ cd $NATS_HOME
$ ./gnatsd
[13527] 2016/02/10 20:27:51.837710 [INF] Starting gnatsd version 0.7.2
[13527] 2016/02/10 20:27:51.839904 [INF] Listening for client connections on 0.0.0.0:4222
[13527] 2016/02/10 20:27:51.841600 [INF] gnatsd is ready
```

### Terminal Two
In terminal two, run the consumer:

```
$ mvn -Pconsumer exec:java
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
(3 KB at 3.0 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
```

### Terminal Three
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
The results of running the producer is that the consumer will consume the messages. You should see the following output from the consumer indicating that it has consumed the 10 messages that are sent by default:

```
$ mvn -Pconsumer exec:java
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building nats-examples 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
Downloading: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml
Downloaded: https://oss.sonatype.org/content/repositories/snapshots/io/nats/jnats/0.4.0-SNAPSHOT/maven-metadata.xml (3 KB at 3.0 KB/sec)
[INFO]
[INFO] --- exec-maven-plugin:1.4.0:java (default-cli) @ nats-examples ---
INFO  - SimpleMessageListener          - Received message: Hello NATS! '0' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '1' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '2' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '3' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '4' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '5' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '6' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '7' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '8' Wed Feb 10 20:31:17 MST 2016
INFO  - SimpleMessageListener          - Received message: Hello NATS! '9' Wed Feb 10 20:31:17 MST 2016
```

## TODO
There's plenty more to demonstrate using NATS and over time I hope to do so. Check back often ;-).