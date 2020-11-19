# Where is the IDL?

There is no IDL compiler in this springboot featured project. Java interface + Java annotation is actually the way to define your procedure/service.

Refers to [ExampleServerAPI.java](https://discl.cs.ttu.edu/gitlab/zhangwei217245/AOS-demo-project/blob/master/JsonRPCDemo/src/main/java/edu/ttu/api/ExampleServerAPI.java)

# What is the server stub?

Literally, springboot framework already prepare the server stub for you, and the server stub is based-on an embedded HTTP server. The `@JsonRpcService("/rpc/calculator")` annotation makes springboot framework expose the java method as an HTTP service.

# Why JSON RPC?

HTTP-based RPC service actually simplifies the development of client-side program. As long as your client-side program can perform HTTP request with correct message, you will be able to invoke the remote java procedure. You can even invoke such procedure via HTTP by simply using command line tools - `curl`:

```
curl -H "Content-Type:application/json" -d '{"id":"1","jsonrpc":"2.0","method":"multiplier","params":{"a":5,"b":6}}' http://localhost:9090/rpc/calculator
```

# How to run this Demo:

1. Make sure you have the following software installed:
    * Java 8
    * Maven
    
2. Once you download a local copy of this project, in the directory of this project, run :

```
mvn clean package
```

3. Run the compiled program:

```
cd target
java -Dserver.port=9090 -jar JsonRPCDemo-1.0-SNAPSHOT.jar
```

# Use a simple HTTP request to test your JSON RPC service

```
curl -H "Content-Type:application/json" -d '{"id":"1","jsonrpc":"2.0","method":"multiplier","params":{"a":5,"b":6}}' http://localhost:9090/rpc/calculator
```

Note that you can specify any port number to provide your HTTP service, but your URL has to be changed as well when you access that HTTP service.


# References:

* [SpringBoot Official Documents](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/) 
* [JsonRPC4j](https://github.com/briandilley/jsonrpc4j)


