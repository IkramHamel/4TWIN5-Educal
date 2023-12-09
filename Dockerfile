FROM openjdk:8
EXPOSE 8090
ADD target/RestaurantMs-0.0.1-SNAPSHOT.jar RestaurantMS-docker.jar
ENTRYPOINT ["java","-jar","RestaurantMS-docker.jar"]

