package com.yuheng.hackermeet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/yes")
    public String getYes() {
        return "index";
    }
}
