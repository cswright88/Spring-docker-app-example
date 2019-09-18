


##USING MAKE TO BUILD
This will build and start up everything: 

`make docker/reload`

####to stop and remove all docker containers: 
1. `docker stop $(docker ps -a -q)`
1. `docker rm $(docker ps -a -q)`


