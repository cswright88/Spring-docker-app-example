 
 ##Manual Process (THIS WORKS) : 
 -- pull the stuff needed intially: docker pull mysql/mysql-server:latest

$ `docker run --name=mysql01 -d mysql/mysql-server:latest`

to view the logs with the pass

$ `docker logs mysql01`

to login: 

$ `docker exec -it mysql01 mysql -uroot -p
`

run alter use for new pass
`ALTER USER 'root'@'localhost' IDENTIFIED BY 'newpassword';`


## Try this with docker file 

docker build -t my-mysql .

`docker run -d -p 3306:3306 --name my-mysql \
 -e MYSQL_ROOT_PASSWORD=supersecret my-mysql`

To view the commandline db: 
`docker exec -it my-mysql bash
mysql -uroot -p
password is supersecret`



to stop and remove all docker containers: 

`docker stop $(docker ps -a -q)`

`docker rm $(docker ps -a -q)`


### To clean and rebuild everything :

`mvn clean`

`mvn install`

`mvn package`

`docker build -f Dockerfile -t demovideo .`
