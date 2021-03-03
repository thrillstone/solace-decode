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

# Developer Resources

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Getting started with Solace and Spring](https://www.solace.dev/start-spring-io-help/)
* [Solace Developer Portal](https://solace.dev)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#production-ready)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-elasticsearch)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-mongodb)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
