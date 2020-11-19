package edu.ttu.impl;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import edu.ttu.api.MyService;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class MyServiceImpl implements MyService {

    @Override
    public String sayHelloWorld(String name) {
        return "Hello world, " + name;
    }
}
