.DEFAULT_GOAL:=help

PWD=$(shell pwd)
COMMIT_HASH=$(shell git rev-parse --short HEAD)
POM_VERSION=$(shell xmllint --xpath "//*[local-name()='project']/*[local-name()='version']/text()" pom.xml)

# DOCKER_REPO?=510938208627.dkr.ecr.us-east-1.amazonaws.com/talroo
APP_NAME=demo
ECR_URL?=$(DOCKER_REPO)/$(APP_NAME)
TAG?=$(COMMIT_HASH)

JAR_FILE=target/$(APP_NAME)-$(POM_VERSION).jar

docker/up: ## Start Docker services
	docker-compose up -d mysql
	@echo Waiting for MySQL to start
	@sleep 10
	./mvnw flyway:migrate

docker/build: target/demo-*.jar ## Build Docker image
	docker build --build-arg JAR_FILE=$(JAR_FILE) -t $(APP_NAME):$(TAG) .

docker/down: ## Stop Docker services
	docker-compose down

docker/run: docker/build ## Run the app using Docker
	docker-compose up demo