package c29.jad.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "Hello World!!!caf42d42c09b09109c6d97234c02b850e373a7e2!!";
    }
}
