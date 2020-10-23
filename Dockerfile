FROM payara/micro:jdk11
COPY target/integrum-ee.war $DEPLOY_DIR
