# solace-decode
deCODE 2021

# Run the Server

If you don't already have them running, create the services needed for the server:

```shell
cd docker
docker-compose up -d
```

Then to run the server:

```shell
./mvnw spring-boot:run
```

## Actions

### Save a Message
Publish a message to topic `message` whose payload that has the structure of `{"id": "abc", "payload": "blah"}`. This will store the message in MongoDB and index it in Elasticsearch.

### Get and Log a Message on the Server
Publish a message with any payload (can't be `null`) to topic `print/message/{id}` where `{id}` is the message ID.

### Provision a Queue & Save It
Publish a message to topic `provision/queue` whose payload is the queue name. This will store the message in MariaDB.
