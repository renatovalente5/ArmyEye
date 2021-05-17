package com.project.ArmyEye.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/myapp")
@CrossOrigin("*")
public class ArmyEyeController {

    @GetMapping("/map")
    public String getMap(){
        return "Map here";
    }

    @GetMapping("/comp1")
    public String getComp1(){
        return "componente 1";
    }

    @GetMapping("/comp2")
    public String getComp2(){
        return "componente 2, acrescentear conteúdos";
    }
}
