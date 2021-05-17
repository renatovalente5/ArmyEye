package com.project.ArmyEye.Controllers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

@RestController
//@RequestMapping("/myapp")
@CrossOrigin("*")
public class ArmyEyeController {

    private List<String[]> armys = new ArrayList<String[]>();

    @GetMapping("/map")
    @Scheduled(fixedRate = 5000)
    public String getMap(){
        File file = new File("java/com/project/ArmyEye/sample_data/GPS.tsv");
        armys = tsvr(file);
        System.out.println("armys:" + armys);
        return "Map here";
    }

    public static ArrayList<String[]> tsvr(File test2) {
        ArrayList<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(test2))) {
            System.out.println("aaaaaa");
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                System.out.println("bbbbbb");
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                Data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
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