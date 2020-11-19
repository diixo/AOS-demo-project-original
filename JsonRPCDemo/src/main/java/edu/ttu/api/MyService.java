package edu.ttu.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/rpc/myservice")
public interface MyService {

    String sayHelloWorld(String name);
}
