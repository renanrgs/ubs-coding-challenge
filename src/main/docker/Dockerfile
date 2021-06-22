FROM openjdk
VOLUME /tmp
ADD maven/ubs-coding-challenge-0.0.1-SNAPSHOT.jar countryapi.jar
RUN sh -c 'touch /countryapi.jar'
ENTRYPOINT ["java", "-jar", "/countryapi.jar"]
