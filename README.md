# fuxpin-legacy-ventas-rol-microservice

Microservice integrated with ``Spring Cloud Netflix Eureka``. It microservice provides the role of legacy application. It implements the Black box Modernization with a microservice layer. The comunication between the systems is via REST.

Main interface communication: ``RolesController``.

Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port.

## Current version
![](https://img.shields.io/badge/fuxpin%20legacy%20ventas%20rol%20microservice-0.0.1-blue)

# Define Enviorment

VM Options -> -Dspring.profiles.active=production

## Enviorment variables

In Spring Boot task -> ***VM options*** define:

````
-Drest.user=user                 -> Spring Cloud Config Server - user
-Drest.password=password         -> Spring Cloud Config Server - Password
-Dpostgresql.user=user           -> Database Login
-Dpostgresql.password=password   -> Database Password
````

To enable the *production* profile. In this cas, the server run reading production properties. In ***VM options*** define:

````
-Dspring.profiles.active=production
````

## Examples *Serverless* execution

* default (localhost):

``C:\Users\amgri\.jdks\jdk-11.0.7\bin\java -jar -Drest.user=user -Drest.password=passwrod -Dpostgresql.user=user -Dpostgresql.password=password .\fuxpin-legacy-ventas-rol-microservice-0.0.1.jar``

* production:

``C:\Users\amgri\.jdks\jdk-11.0.7\bin\java -jar -Dspring.profiles.active=production -Drest.user=user -Drest.password=passwrod -Dpostgresql.user=user -Dpostgresql.password=password .\fuxpin-legacy-ventas-rol-microservice-0.0.1.jar``

````
$ gradew clean assemble
````
jar location
````
${PROJECT_DIRECTORY}/build/libs/
````

## Production launcher

Windows: Windows + R -> CMD
````
C:\Users\amgri\.jdks\jdk-11.0.7\bin\java -Xms128m -Xmx256m -jar -Dspring.profiles.active=production -Drest.user=user -Drest.password=password -Dpostgresql.user=user -Dpostgresql.password=password -Deureka.user=user -Deureka.password=password .\fuxpin-legacy-ventas-rol-microservice-0.0.1.jar
````

## Create a Run Java Jar Application with Systemd
* For this configuration *pi* user is used to run the serveless installation. Before proced, create a directory:
````
/opt/java-jar 
````
Give the user ang group ownership permissions for the Fuxpin Systems Jars:
````
sudo chown -R pi:pi /opt/java-jars 
````
* Create Systemd Service
````
sudo vi /etc/systemd/system/fuxpixlegacyventasrolmicroservice.service
````
with contents:
````editorconfig
[Unit]
Description=Fuxpin Legacy Ventas Role Microservice

[Service]
WorkingDirectory=/opt/java-jars
ExecStart=java -Xms128m -Xmx256m -jar -Dspring.profiles.active=production -Dkeystore.password=password -Drest.user=user -Drest.password=password fuxpin-legacy-ventas-rol-microservice-0.0.1.jar
User=pi
Type=simple
Restart=on-failure

[Install]
WantedBy=multi-user.target
````

* Before start the application, reload systemd so that it knows ot the new service added:

````
sudo systemctl daemon-reload
````

* Once realoaded, the service is avaliable:

````
sudo systemctl start fuxpixlegacyventasrolmicroservice
````
* Also, verify the status:

````
sudo systemctl status fuxpixlegacyventasrolmicroservice
````
Result:

````
● fuxpixlegacyventasrolmicroservice.service - Fuxpin Legacy Ventas Role Microservice
   Loaded: loaded (/etc/systemd/system/fuxpixlegacyventasrolmicroservice.service; disabled; vendor preset: enabled)
   Active: active (running) since Thu 2021-05-27 17:45:20 CEST; 1min 39s ago
 Main PID: 4022 (java)
    Tasks: 44 (limit: 4915)
   Memory: 226.3M
   CGroup: /system.slice/fuxpixlegacyventasrolmicroservice.service
           └─4022 /usr/bin/java -Xms128m -Xmx256m -jar -Dspring.profiles.active=production -Drest.user=user -Drest.password=password -Dpostgresql.user=user -Dpostgresql.password=password fuxpin-legacy-ventas-rol-microservice-0.0.1.jar

May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,375 INFO  com.netflix.discovery.DiscoveryClient : The response status is 200
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,387 INFO  com.netflix.discovery.DiscoveryClient : Starting heartbeat executor: renew interval is: 10
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,398 INFO  com.netflix.discovery.InstanceInfoReplicator : InstanceInfoReplicator onDemand update allowed rate per min is 4
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,419 INFO  com.netflix.discovery.DiscoveryClient : Discovery Client initialized at timestamp 1622130359416 with initial instances count: 2
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,429 INFO  org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry : Registering application FUXPIN-ROLE-MICROSERVICE with eureka with status UP
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,431 INFO  com.netflix.discovery.DiscoveryClient : Saw local status change event StatusChangeEvent [timestamp=1622130359431, current=UP, previous=STARTING]
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,439 WARN  com.netflix.discovery.InstanceInfoReplicator : Ignoring onDemand update due to rate limiter
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,474 INFO  com.netflix.discovery.DiscoveryClient : DiscoveryClient_FUXPIN-ROLE-MICROSERVICE/pi.intranet.cat:fuxpin-role-microservice:0: registering service...
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,539 INFO  unir.tfg.fuxpin.fuxpinlegacyventasrolmicroservice.EurekaClientApplication : Started EurekaClientApplication in 35.809 seconds (JVM running for 39.335)
May 27 17:45:59 raspberrypi java[4022]: 2021-05-27 17:45:59,834 INFO  com.netflix.discovery.DiscoveryClient : DiscoveryClient_FUXPIN-ROLE-MICROSERVICE/pi.intranet.cat:fuxpin-role-microservice:0 - registration status: 204
````

* To stop the application:

````
sudo systemctl stop fuxpixlegacyventasrolmicroservice
````

* To restart the application:

````
sudo systemctl restart fuxpixlegacyventasrolmicroservice
````

* To enable the service on startup server boot:
````
sudo systemctl enable fuxpixlegacyventasrolmicroservice
````
Result:

````
Created symlink /etc/systemd/system/multi-user.target.wants/fuxpixlegacyventasrolmicroservice.service → /etc/systemd/system/fuxpixlegacyventasrolmicroservice.service.
````

# More info:

* https://www.baeldung.com/spring-boot-json
* https://spring.io/blog/2015/07/14/microservices-with-spring
* https://www.baeldung.com/spring-cloud-netflix-eureka
* https://stackoverflow.com/questions/63026751/json-decoding-error-root-name-timestamp-does-not-match-expected-eureka-sprin
* https://spring.io/guides/gs/service-registration-and-discovery/
* https://howtodoinjava.com/spring-cloud/spring-cloud-service-discovery-netflix-eureka/
* https://stackoverflow.com/questions/50971891/how-to-secure-spring-cloud-eureka-service-with-basic-auth/51024117#51024117

