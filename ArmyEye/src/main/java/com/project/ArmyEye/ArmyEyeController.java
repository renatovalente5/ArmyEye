package com.project.ArmyEye;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class ArmyEyeController {

    @GetMapping("/ola")
    public String getMsg(){
        return "ola";
    }
}
