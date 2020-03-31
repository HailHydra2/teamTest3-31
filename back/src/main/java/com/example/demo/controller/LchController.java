package com.example.demo.controller;

import com.example.demo.model.AjaxResponse;
import com.example.demo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/lch")
public class LchController {

    @RequestMapping("/user")
    public AjaxResponse wshControll(@RequestBody user u){
        log.info("user {}", u);
        u.setName("lch");
        u.setAge(20);
        return AjaxResponse.success(u);
    }
}
