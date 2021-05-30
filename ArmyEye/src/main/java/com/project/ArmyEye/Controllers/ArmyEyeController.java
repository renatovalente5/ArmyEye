package com.project.ArmyEye.Controllers;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.repository.GPSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/myapp")
@CrossOrigin("*")
public class ArmyEyeController {

    @Autowired
    private GPSRepository gpsRepository;

    public static LinkedList<GPS> getArmyGPS() {
        return armyGPS;
    }

    public Map<String, LinkedList<GPS>> getTrackerArmyGPS() {
        return trackerArmyGPS;
    }

    private final GPSRepository getGpsRepository;
    private boolean init = true;
    private static LinkedList<GPS> armyGPS;
    private static LinkedList<GPS> armyGPSaux;
    private static LinkedList<GPS> movesArmyGPS;
    private Map<String, LinkedList<GPS>> trackerArmyGPS = new HashMap<>();


    @GetMapping("/map")
    @Scheduled(fixedRate = 100000)
    public LinkedList<GPS> getMap(){
        LinkedList<GPS> passo = new LinkedList<GPS>();
        if(init==true) {
            armyGPS = new LinkedList<>();
            //LinkedList<Comp1> auxList = new LinkedList<>();
            List<String[]> armys = tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
            int i = 0;
            for (String[] str : armys) {
                if (i > 0 && i < 100) {
                    gpsRepository.save(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    armyGPS.add(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3] + " " + str[4] + " " + str[5]);
                }
                i++;
            }
            System.out.println("--asasas---");
            armyGPSaux = armyGPS;
            movesArmyGPS = new LinkedList<GPS>();
            init = false;
        }else {
            GPS aux = armyGPSaux.getFirst();
            System.out.println("--Deu Passo----" + aux.getAltitude());
            passo.add(aux);
            movesArmyGPS.add(aux);
            armyGPSaux.removeFirst();
            getGpsRepository.save(aux);
        }
        return passo;
    }

    public static List<String[]> tsvr(String test2) {
        List<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try{
            BufferedReader TSVReader = new BufferedReader(new FileReader(test2));
            System.out.println("aaaaaab");
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                //System.out.println(line);
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                Data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Data;
    }

    @GetMapping("/gps")
    public Iterable<GPS> getComp1(){
        System.out.println("Foi à BD!");
        System.out.println("---------------\n");
        return getGpsRepository.findAll();
    }


    @GetMapping("/comp2")
    public String getComp2(){
        return "componente 2, acrescentear conteúdos";
    }
}
