


##USING MAKE TO BUILD
This will build and start up everything: 

`make docker/reload`

##MANUAL PROCESS
####to stop and remove all docker containers: 
1. `docker stop $(docker ps -a -q)`
1. `docker rm $(docker ps -a -q)`

####Dev environment run both mysql and spring
1. build the docker image for mysql: 
`cd mysql-dev && docker build -f Dockerfile -t mysql-docker .`

1. clean and repackage the spring boot jar 
`mvn clean install package`
1. Build the docker file for the spring application
`docker build -f Dockerfile -t demovideo .`
1. run docker compose up to start it
`docker-compose up demo`


