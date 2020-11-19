package ttu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttu.edu.api.ExampleClientAPI;

@Service
public class ExampleService {
    @Autowired
    private ExampleClientAPI exampleClientAPI;

    public int multiply(int a, int b) {
        return exampleClientAPI.multiplier(a, b);
    }
}