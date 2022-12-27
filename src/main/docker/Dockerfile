FROM amazoncorretto:17-alpine

WORKDIR /usr/local/bin/app

EXPOSE 8080

COPY maven/webflux-practise-0.0.1-SNAPSHOT.jar ROOT.jar

CMD ["java", "-jar", "ROOT.jar"]
