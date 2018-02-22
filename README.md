# Spring Boot Kafka Producer Consumer

This is a sample application that shows how to write Kafka Producer & Consumer using
 - Spring Boot 1.5.10
 - Spring Kafka
 
For this application, I have used "spotify/kafka" docker image; which runs both Kafka and Zookeeper in the same container.
<br/>
``` https://github.com/spotify/docker-kafka```

### Starting Kafka and Zookeeper
```
docker run -itd -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=127.0.0.1 --env ADVERTISED_PORT=9092 spotify/kafka

This will start Kafka on port 9092 and Zookeeper on 2181.
```

### Configuration
```
resources/application.yml file contains below configuration:

- Kafka IP & Port
- Topic names
```

### Running the application

Run using the included maven wrapper

```
./mvnw spring-boot:run
```



## cURL Commands

You can try the following API's once the server is running.

GET __/sendMessage__

``` curl http://localhost:8080/sendMessage?message=Test ```

POST __/person__

``` 
curl -X POST \
  http://localhost:8080/sendMessage \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"firstName": "First",
	"lastName": "Last",
	"id": "1"
}'
```


