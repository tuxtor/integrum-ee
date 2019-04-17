#!/bin/sh
mvn clean package && docker build -t com.nabenik/integrum-ee .
docker rm -f integrum-ee || true && docker run -d -p 8080:8080 -p 4848:4848 --name integrum-ee com.nabenik/integrum-ee 
