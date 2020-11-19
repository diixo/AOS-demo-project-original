package edu.ttu.impl;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import edu.ttu.api.ExampleServerAPI;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class ExampleServerAPIImpl implements ExampleServerAPI {
    @Override
    public int multiplier(int a, int b) {
        return a * b;
    }
}