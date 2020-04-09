package com.example.demo.controller;


import com.example.demo.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/wsh")
public class WshController {

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

    @RequestMapping("/test")
    public AjaxResponse test(){
        user u = new user();
        u.setAge(10);
        u.setName("abc");
        return AjaxResponse.success(u);
    }

    @RequestMapping("/list")
    public AjaxResponse a(){
        List<user> list = new ArrayList<>();
        for(int i = 0; i <5; i++){
            user u = new user();
            u.setName("wsh" + i);
            u.setAge(20 + i);
            list.add(u);
        }
        return AjaxResponse.success(list);
    }

    @RequestMapping("/articles")
    public @ResponseBody AjaxResponse getPage(@RequestBody Page page, HttpServletRequest request){
        page.setArticles(new ArrayList<Article>());
        Cookie cookie = new Cookie("test","hello");
        request.getSession().setAttribute("name","hellow");
        System.out.println("session id:" + request.getSession().getId());
        for(int i = 0; i < page.getCount(); i++){
            Article article = new Article();
            article.setContent("第" + page.getPageIndex() + "页" + "content" + i);
            article.setTitle("第" + page.getPageIndex() + "页" + "title" + i);
            page.getArticles().add(article);
        }
        page.setHasPrevious(true);
        page.setHasNext(true);
        System.out.println(page.getPageIndex());
        return AjaxResponse.success(page);
    }

    @RequestMapping("/error")
    public @ResponseBody AjaxResponse getError(){
        System.out.println("error");
        return AjaxResponse.error();
    }

    @RequestMapping("/login")
    public @ResponseBody AjaxResponse login(@RequestBody user u){
        System.out.println(u.getName() + "  " + u.getAge());
        u.setName("wsh haha");
        u.setAge(20);
        return AjaxResponse.success(u);
    }

    @RequestMapping("/grid")
    public @ResponseBody List<Grid> getGrid(){
        List<Grid> list = new ArrayList<>();
        for(int i = 0; i <10; i++){
            Grid grid = new Grid();
            grid.setId(i);
            grid.setLink("link" + i);
            grid.setNum(i*10);
            grid.setUserid(i*2);
            list.add(grid);
        }
        return list;
    }

}
