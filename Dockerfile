FROM arm64v8/eclipse-temurin:21-jammy as builder
WORKDIR /library-api
COPY . /library-api
RUN ./gradlew build -x test --console=plain

FROM arm64v8/eclipse-temurin:21-jre-jammy
LABEL maintainer="Mehmet Akif Tütüncü <m.akif.tutuncu@gmail.com>"
WORKDIR /library-api
COPY --from=builder /library-api/build/libs/library-api-*.jar /library-api/library-api.jar
ENTRYPOINT ["java", "-jar", "/library-api/library-api.jar"]
