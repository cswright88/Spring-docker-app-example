clean/package: ## Clean and reinstall/package java artifacts
	./mvnw clean install package

docker/image: ## build both images for docker compose
	docker build -f Dockerfile -f Dockerfile -t demovideo .
	@echo ****************** MADE SPRING IMAGE ******************
	docker build -f Dockerfile-mysql -t my-mysql .
	@echo ****************** MADE MYSQL IMAGE ******************

docker/up: ## start the image using docker-compose
	docker-compose up demo

docker/reload: clean/package docker/image docker/up
