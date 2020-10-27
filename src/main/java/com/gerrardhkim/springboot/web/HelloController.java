package com.gerrardhkim.springboot.web;

import com.gerrardhkim.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("nam") String name,
                                     @RequestParam("amoun") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
