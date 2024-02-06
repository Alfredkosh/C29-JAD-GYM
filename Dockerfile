FROM amazoncorretto:17
WORKDIR /usr/src/app
COPY ./build/libs/c29-jad-gympj.jar .
EXPOSE 8080
CMD java -jar c29-jad-gympj.jar \
    --spring.config.location=file:./config/application.properties