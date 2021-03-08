FROM openjdk:11

### Root directory
WORKDIR /home

### Install dependencies
RUN apt update && apt install -y curl

### Download and install Maven
ARG MAVEN_VERSION=3.6.3

ARG SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0

ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downloading maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "Checking download hash" \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

### Copy basic application
COPY app app
COPY proto proto
#
#### Install application
RUN bash app/scripts/install.sh

### Copy commands
COPY scripts/entrypoint.sh scripts/command.sh /

### Healthcheck
# TODO(pawelk): add HEALTHCHECK --interval=20s --timeout=1s --retries=3 CMD ["bash", "/healthcheck.sh"]

#### Execution command
ENTRYPOINT ["bash", "/entrypoint.sh"]
CMD ["bash", "/command.sh"]
