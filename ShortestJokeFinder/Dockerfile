FROM adoptopenjdk/openjdk11 as build
WORKDIR /workspace/app

COPY target target

# Build the application fat jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

LABEL io.k8s.description="Ns Jokefinder Service" \
  io.k8s.display-name="Ns Jokefinder API" \
  io.openshift.expose-services="8080:http" \
  io.openshift.tags="mint"

ENV APP_DIR="/opt/mint/app" 

ENV HEAP_SIZE_MIN="32m" \
  HEAP_SIZE_MAX="512m" \
  METASPACE_SIZE_MIN="32m" \
  METASPACE_SIZE_MAX="192m" \
  TZ="Europe/Amsterdam"
	
RUN mkdir -p ${APP_DIR}/lib && \
  mkdir -p ${APP_DIR}/conf && \
  mkdir -p ${APP_DIR}/META-INF && \
  chgrp -R 0 ${APP_DIR} && \
  chmod -R g=u ${APP_DIR}

# not needed, using jetty
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
# create layers
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib ${APP_DIR}/lib
COPY --from=build ${DEPENDENCY}/META-INF ${APP_DIR}/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes ${APP_DIR}
COPY config/* ${APP_DIR}/conf/

# Start  the application
CMD /opt/java/openjdk/bin/java \
  -noverify \
  -Xms${HEAP_SIZE_MIN} \
  -Xmx${HEAP_SIZE_MAX} \
  -XX:MetaspaceSize=${METASPACE_SIZE_MIN} \
  -XX:MaxMetaspaceSize=${METASPACE_SIZE_MAX} \
  -Dspring.config.location=${APP_DIR}/conf/,optional:${APP_DIR}/conf/extra/ \
  ${JAVA_OPTS} \
  ${EXTRA_JAVA_OPTS} \
  -cp ${APP_DIR}:${APP_DIR}/lib/* \
  nl.ns.task.jokefinder.JokeFinderApplication
