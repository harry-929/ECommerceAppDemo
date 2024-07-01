package com.example.ecommerceappdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{from}/{to}")
    public String getName(@PathVariable("from") String userName1, @PathVariable("to") String userName2){
        System.out.println("I am in path variable");
        return "hello from "+ userName1+ " to "+ userName2;
    }

    @GetMapping()
    public String getNameByRequestParam(@RequestParam(name = "from") String userName,
                                        @RequestParam(name = "to") String toName){
        System.out.println("I am in request Param");
        return "Hello from "+ userName+ " to "+ toName;
    }
}
