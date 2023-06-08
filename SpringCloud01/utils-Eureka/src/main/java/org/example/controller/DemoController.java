package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/one")
    public String one() {
        return "one";
    }

    @RequestMapping("one/two")
    public String two() {
        return "two";
    }
}
