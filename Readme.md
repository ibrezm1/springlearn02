# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.6/gradle-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.6/gradle-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.6/reference/htmlsingle/index.html#web)

## Guides
The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## Additional Links
These additional references should also help you:

- [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Actuator Endpoints
Access these actuator endpoints to monitor and manage your application:

- [Actuator Info](http://localhost:8081/actuator/info)
- [Actuator Audit Events](http://localhost:8081/actuator/auditevents)
- [Actuator Beans](http://localhost:8081/actuator/beans)
- [Actuator Mappings](http://localhost:8081/actuator/mappings)
- [Actuator Metrics](http://localhost:8081/actuator/metrics) (e.g., `/actuator/metrics/jvm.memory.used`)
- [Actuator Conditions](http://localhost:8081/actuator/conditions)

For more details on Spring Boot Actuator endpoints, refer to the [Spring Boot Actuator Endpoints documentation](https://docs.spring.io/spring-boot/reference/actuator/endpoints.html#page-title).

## Additional Resources and Links
- [Access GCS Bucket in Spring Boot](https://stackoverflow.com/questions/59858391/how-to-access-gcs-bucket-in-springboot)
- [Spring Cloud GCP Reference Documentation](https://cloud.spring.io/spring-cloud-static/spring-cloud-gcp/current/reference/html/#_spring_resources)
- [Google Cloud Java Client Libraries BOM](https://cloud.google.com/java/docs/bom)
- [GCP Key Setup](https://github.com/spring-attic/spring-cloud-gcp/issues/1630)
- [Google AutoConfig Example](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/blob/main/spring-cloud-gcp-starters/spring-cloud-gcp-starter-storage/pom.xml)
- [Old Generation Code](https://chatgpt.com/share/b1a06091-8e86-4503-91c6-d55d7a7e35b8)
- [Spring Boot GCS Demo Application YML](https://github.com/raviyasas/springboot-gcs-demo/blob/225606faa720f2b036d16d96316db62d9f8d0b67/src/main/resources/application.yml)

## Example Commands

- **To list project dependencies**:
  ```sh
  ./gradlew dependencies
  ```
