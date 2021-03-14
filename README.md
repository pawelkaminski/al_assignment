## Project

Project is build around java 11. It implements quote server and market data client stub (only setting up RPC server 
and printing out trade messages). It can be build both via mvn and docker. 

### Configuration

Every setup is configured via env variables:

* QS_HOST - quote server host
* QS_PORT - quote server port
* MD_HOST - market data client host
* MD_PORT - market data client port

### Run via java build

Before running the specific process please setup env variables (or there would be default setup)

To build and run quote server:

```shell
cd quote_server/app
mvn clean && mvn install
java -jar target/quote-server-1.0-SNAPSHOT-jar-with-dependencies.jar
```

To build and run market data client:

```shell
cd quote_server/app
mvn clean && mvn install
java -jar target/market-data-client-1.0-SNAPSHOT-jar-with-dependencies.jar
```


### Run via docker compose

To prevent form multi times building of same image in docker-compose, docker images should be 
Build docker images:
```shell
sudo docker build  -f market_data_client/Dockerfile -t  client market_data_client
sudo docker build  -f quote_server/Dockerfile -t  quote_server quote_server
```

Configure as many docker images in docker-compose.yml as you want, then run docker compose:
```shell
sudo docker-compose up 
```

### TODO 

* Unit Tests
* Add logging mechanism
* Change single RPC call to the Client streaming rpc, this would send everything what we have got in the messages
queue. (https://grpc.io/docs/languages/java/basics/#client-side-streaming-rpc)


