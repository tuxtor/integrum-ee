FROM payara/micro
COPY ./target/integrum-ee.war ${DEPLOYMENT_DIR}
