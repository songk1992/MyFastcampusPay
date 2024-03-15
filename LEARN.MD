http://localhost:8080/swagger-ui/index.html
http://localhost:8080/h2-console

./gradlew docker

docker-compose up -d --build membership-service
docker-compose up -d --build banking-service
docker-compose up -d --build money-service
docker-compose up -d --build logging-consumber-service
