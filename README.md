Build docker images:
I want to prevent form multi times building of same image in docker-compose
```shell
sudo docker build  -f market_data_client/Dockerfile -t  client market_data_client
sudo docker build  -f quote_server/Dockerfile -t  quote_server quote_server
```

Configure as many docker images in docker-compose.yml as you want, then run docker compose:
```shell
sudo docker-compose up 
```
