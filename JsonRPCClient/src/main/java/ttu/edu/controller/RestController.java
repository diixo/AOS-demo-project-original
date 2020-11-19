package ttu.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ttu.edu.service.ExampleService;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/rest") // This means URL's start with /demo (after Application path)
public class RestController {

    @Autowired
    private ExampleService service;
    @PostMapping(path="/multiply")
    public @ResponseBody
    int multiply(@RequestParam int a
            , @RequestParam int b) {
        // This returns a JSON or XML with the users
        return service.multiply(a, b);
    }
}
