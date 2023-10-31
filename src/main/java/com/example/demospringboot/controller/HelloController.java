package com.example.demospringboot.controller;

/*
@Controller: Dung de dinh nghia duong dan tra ra HTML
@ResponseBody: Giup Controller tra ra String de viet API

@RestController: Ket hop Controller and ResponseBody => Viet API
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("")
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("cybersoft")
    public String helloCyber() {
        return "Hello Cyber Soft";
    }
}
