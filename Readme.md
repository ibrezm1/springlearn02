# Getting Started

```
curl --location 'localhost:8081/validate' \
--header 'Content-Type: application/json' \
--data '{
  "order_id":"order134",
   "event": "PLACED",
   "products": [
     {
       "product_id": "product_1",
        "price":20.5,
       "quantity":2
     }
   ],
   "total_price": 41
}'
{"originalMessage":{"order_id":"order134","event":"PLACED","products":[{"product_id":"product_1","price":20.5,"quantity":2}],"total_price":41},"errors":[]}

```



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

## Heap dump analysis
Memory leaks in a Spring Boot application can be challenging to diagnose and resolve, but there are several steps you can take to identify and address the issue:

### 1. **Enable Detailed Logging and Monitoring**
   - **Heap Dumps:** Enable heap dumps to capture the state of your application's memory at specific intervals or when an OutOfMemoryError occurs.
   - **Garbage Collection Logs:** Enable GC logging to understand how memory is being allocated and reclaimed.

### 2. **Use Profiling Tools**
   - **VisualVM:** A visual tool that integrates with the JVM and can be used to monitor memory usage and take heap dumps.
   - **JProfiler or YourKit:** More advanced profiling tools that can help in identifying memory leaks by showing detailed object creation and retention paths.
   - **Eclipse MAT (Memory Analyzer Tool):** Analyze heap dumps to identify memory leaks.

### 3. **Analyze Heap Dumps**
   - Use tools like Eclipse MAT to analyze heap dumps and identify objects that are consuming a lot of memory.
   - Look for objects that are retained even though they are no longer needed.

### 4. **Check for Common Memory Leak Patterns**
   - **Unclosed Resources:** Ensure that all database connections, file streams, and other resources are properly closed.
   - **Static Fields:** Be cautious with the use of static fields, as they can hold onto objects longer than necessary.
   - **Listeners and Callbacks:** Ensure that event listeners and callbacks are properly deregistered when they are no longer needed.
   - **Caching:** Review your caching strategy to ensure that caches do not grow indefinitely.

### 5. **Review Code for Potential Issues**
   - **Spring Beans:** Make sure that your Spring beans have the correct scope. For instance, using singleton scope beans for objects that should not be shared globally can lead to memory leaks.
   - **Collections:** Watch out for collections (e.g., lists, maps) that grow without bounds.

### 6. **Use Memory Leak Detection Libraries**
   - **Java Flight Recorder (JFR):** A profiling and diagnostic tool that can be used to record events and analyze memory usage.
   - **Apache Commons Pool:** For applications using object pooling, ensure that objects are properly returned to the pool.

### 7. **Optimize JVM Parameters**
   - **Heap Size:** Configure the heap size appropriately using `-Xms` and `-Xmx` JVM parameters.
   - **Garbage Collector:** Experiment with different garbage collectors (e.g., G1, CMS) to see if they perform better with your application.

### Steps to Diagnose and Fix a Memory Leak

1. **Enable Heap Dumps and GC Logs:**
   ```bash
   -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/path/to/heapdump.hprof
   -Xlog:gc*:file=/path/to/gc.log:time
   ```

2. **Take Regular Heap Dumps:**
   ```bash
   jmap -dump:live,format=b,file=heapdump.hprof <pid>
   ```

3. **Analyze Heap Dumps:**
   - Open the heap dump file with Eclipse MAT.
   - Look for objects that are retained in memory and identify why they are not being garbage collected.

4. **Review and Refactor Code:**
   - Fix issues found during heap dump analysis, such as unclosed resources, incorrect bean scopes, and improper cache management.

5. **Use Profiling Tools:**
   - Run your application under a profiler like JProfiler or YourKit to monitor memory usage and identify problematic areas.

6. **Monitor and Test:**
   - Continuously monitor your application in production and during load testing to ensure that memory usage remains stable.

By following these steps, you should be able to identify and resolve memory leaks in your Spring Boot application.
