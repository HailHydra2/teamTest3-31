package com.example.demo.controller;

import com.example.demo.model.AjaxResponse;
import com.example.demo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/lch")
public class LchController {

    @PutMapping("/hello1")
    public @ResponseBody
    AjaxResponse updateArticle(@RequestBody Article article) {

        /*article.setId(id);
        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
         */
        return AjaxResponse.success(article);

    }

    @PostMapping("/user")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody user use) {
        log.info("saveArticle:{}",use);

        use.name="liuchenghua";
        return AjaxResponse.success(use);

    }
}
