FROM openjdk
VOLUME /tmp
ADD maven/ubs-coding-challenge-0.0.1-SNAPSHOT.jar countryapi.jar
RUN sh -c 'touch /countryapi.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/ ./urandom", "-jar", "/countryapi.jar"]
