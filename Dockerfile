FROM eclipse-temurin:17 as build
COPY . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
