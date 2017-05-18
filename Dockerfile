FROM java:8
VOLUME /tmp
ADD build/libs/task-1.0.0.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom -DapiKey=$apikey", "-jar","/app.jar"]
