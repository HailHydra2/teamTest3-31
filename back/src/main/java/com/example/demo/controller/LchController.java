package com.example.demo.controller;

import com.example.demo.model.AjaxResponse;
import com.example.demo.model.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/lch")
public class LchController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/user")
    public AjaxResponse wshControll(@RequestBody user u){
        log.info("user {}", u);
        u.setName("wsh");
        u.setAge(20);
        return AjaxResponse.success(u);
    }
}
