package com.cookBook.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainController
 */
@RestController
public class MainController {

    @GetMapping(value = "/")
    public String welcomePage() {
        return new String("Hello System");
    }
    
}