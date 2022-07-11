package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkController {
    @RequestMapping("/workbench/index.do")
    public String index() {

        return "workbench/index";
    }


}
