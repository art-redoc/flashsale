package redoc.sq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedocController {
    @GetMapping("/")
    public String get(){
        return "test";
    }
}
