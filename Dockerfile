FROM payara/micro
COPY target/integrum-ee.war $DEPLOY_DIR
