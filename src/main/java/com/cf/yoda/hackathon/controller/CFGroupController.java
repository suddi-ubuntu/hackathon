package com.cf.yoda.hackathon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yoda/group")
public class CFGroupController  extends AbstractYodaController{

	@RequestMapping("index")
    public String index() {
        return "Greetings from Yoda Yoda dharmasya!";
    }
}
