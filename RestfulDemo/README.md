This is another demo of the RESTful service.
It implements functionality of adding users into registration and displaying all registered users.

# How to run this demo

Make sure you have the following software installed:

 * Java 8
 * Maven

Then, on disci head node, run:

```
mvn clean package
cd target
java -Dserver.port=9090 -jar RestfulDemo-1.0-SNAPSHOT.jar
```
* Note that the port number you specified should be unique. Use the following command to check if the port number you want to use is already in use:

```
netstat -ntlp| grep <portnum>
```

## Send RESTful request for adding users:

```
curl "http://localhost:9090/demo/add" -d "name=a&email=a@a.com"
```

## Send RESTful request for displaying all users:

```
curl "http://localhost:9090/demo/all"
```

* Note: if you are using a different port number, change the port number in the request accordingly.

## Test via Web interface:

In your web browser, open `http://disci.hpcc.ttu.edu:9090`

You will see a web interface where you can play with.

## Go through Javascript code:

[user-add.component.js](https://discl.cs.ttu.edu/gitlab/zhangwei217245/AOS-demo-project/blob/master/RestfulDemo/src/main/resources/static/user/user-add/user-add.component.js)
[user-display.component.js](https://discl.cs.ttu.edu/gitlab/zhangwei217245/AOS-demo-project/blob/master/RestfulDemo/src/main/resources/static/user/user-display/user-display.component.js) 

You should pay attention to how javascript communicate with your RESTful service and make changes to your web page. 


# References:

* [SpringBoot Official Documents](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* [JsonRPC4j](https://github.com/briandilley/jsonrpc4j)
* [RESTful Tutorial](http://www.restapitutorial.com)
* [Building RESTful Service with Spring MVC](https://spring.io/guides/gs/rest-service/)
* [AngularJS Tutorial](https://docs.angularjs.org/tutorial)
* [AngularJS API Referece](https://docs.angularjs.org/api)

