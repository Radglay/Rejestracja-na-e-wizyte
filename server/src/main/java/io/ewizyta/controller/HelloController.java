package io.ewizyta.controller;

import io.ewizyta.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor //nie musimy robic konstruktora
public class HelloController {


    private final HelloService helloService;

   /* @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }*/


    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }

    @GetMapping("/hello2")
    public String hello2(){
        return helloService.hello();
    }

}
