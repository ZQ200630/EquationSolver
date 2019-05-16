package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputController {
    @RequestMapping(value = "/input",method = RequestMethod.GET)
    public String input(@RequestParam("count") int count, Model model) {
        model.addAttribute("count", count);
        return "input";
    }
}
