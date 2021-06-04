package com.project.ArmyEye.Controllers;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.Helmet;
import com.project.ArmyEye.Models.VitalJacket_ECG;
import com.project.ArmyEye.repository.ECGRepository;
import com.project.ArmyEye.repository.GPSRepository;
import com.project.ArmyEye.repository.HelmetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/myapp")
@CrossOrigin("*")
public class ArmyEyeController {

    @Autowired
    private GPSRepository gpsRepository;

    private final TopicProducer topicProducer;
    private final TopicListener topicListener;

    public static LinkedList<GPS> getArmyGPS() {
        return armyGPS;
    }

    public Map<String, LinkedList<GPS>> getTrackerArmyGPS() {
        return trackerArmyGPS;
    }

    private final GPSRepository getGpsRepository;
    private final HelmetRepository getHelmetRepository;
    private final ECGRepository getECGRepository;

    private boolean init = true;
    private int count = 0;
    private static LinkedList<GPS> armyGPS;
    private static LinkedList<Helmet> armyHelmet;
    private static LinkedList<VitalJacket_ECG> armyECG;

    private static LinkedList<GPS> armyGPSaux;
    private static LinkedList<Helmet> armyHelmetaux;
    private static LinkedList<VitalJacket_ECG> armyECGaux;

    private static LinkedList<GPS> movesArmyGPS;
    private static LinkedList<Helmet> movesArmyHelmet;
    private static LinkedList<VitalJacket_ECG> movesArmyECG;

    private Map<String, LinkedList<GPS>> trackerArmyGPS = new HashMap<>();

    @GetMapping("/map")
    @Scheduled(fixedRate = 10000)
    public LinkedList<Object> getMap(){
        LinkedList<Object> passo = new LinkedList<Object>();
        if(init==true) {
//GPS
            log.info("Starting APP");
            count=0;
            armyGPS = new LinkedList<>();
            //LinkedList<Comp1> auxList = new LinkedList<>();
            List<String[]> gps = tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
            int i = 0;
            for (String[] str : gps) {
                if (i > 0 && i < 1000) {
                    gpsRepository.save(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    armyGPS.add(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3] + " " + str[4] + " " + str[5]);
                }
                i++;
            }
            System.out.println("--asasas---");
            armyGPSaux = armyGPS;
            movesArmyGPS = new LinkedList<GPS>();

//Helmet
            armyHelmet = new LinkedList<>();
            List<String[]> helment = tsvr("src/main/java/com/project/ArmyEye/sample_data/Helmet.tsv");
            i = 0;
            for (String[] str : helment) {
                if (i > 0 && i < 450) {
                    //gpsRepository.save(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    armyHelmet.add(new Helmet(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9]));
                    System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3] + " " + str[4] + " " + str[5]);
                }
                i++;
            }
            armyHelmetaux = armyHelmet;
            movesArmyHelmet = new LinkedList<Helmet>();

//ECG
            armyECG = new LinkedList<>();
            List<String[]> ecg = tsvr("src/main/java/com/project/ArmyEye/sample_data/VitalJacket_ECG.tsv");
            i = 0;
            for (String[] str : ecg) {
                if (i > 0 && i < 1000) {
                    //gpsRepository.save(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
                    armyECG.add(new VitalJacket_ECG(str[0]));
                }
                i++;
            }
            armyECGaux = armyECG;
            movesArmyECG = new LinkedList<VitalJacket_ECG>();

            init = false;
        }else {
//GPS
            GPS auxGPS = armyGPSaux.getFirst();
            armyGPSaux.removeFirst();
            System.out.println("--Deu Passo----" + auxGPS.getAltitude());
            passo.add(auxGPS);
            movesArmyGPS.add(auxGPS);
            getGpsRepository.save(auxGPS);
//Helmet
            if(count%10 == 0) {
                Helmet auxHelmet = armyHelmetaux.getFirst();
                System.out.println("--Helmet ----" + auxHelmet.CO);
                armyHelmetaux.removeFirst();
                //passo.add(auxHelmet);
                movesArmyHelmet.add(auxHelmet);
                getHelmetRepository.save(auxHelmet);
            }

//ECG
            VitalJacket_ECG auxECG = armyECGaux.getFirst();
            System.out.println("--ECG ----" + auxECG.ECG);
            armyECGaux.removeFirst();
            //passo.add(auxHelmet);
            movesArmyECG.add(auxECG);
            getECGRepository.save(auxECG);
            if(Double.parseDouble(auxECG.ECG) > 130 ){
                topicProducer.send("ecg", "ECG is too hight! - " + auxECG.ECG);
            }


            count++;
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
    @Scheduled(fixedRate = 100000)
    public Iterable<GPS> getComp1(){
        log.info("Foi à BD buscar o GPS!");
        //System.out.println("Foi à BD buscar o GPS!");
        //System.out.println("---------------\n");
        return getGpsRepository.findAll();
    }

    @GetMapping("/helmet")
    @Scheduled(fixedRate = 100000)
    public Iterable<Helmet> getHelmet(){
        log.info("Foi à BD buscar o Helmet!");
        //System.out.println("Foi à BD buscar o Helmet!");
        //System.out.println("---------------\n");
        return getHelmetRepository.findAll();
    }

    @GetMapping("/ecg")
    @Scheduled(fixedRate = 100000)
    public Iterable<VitalJacket_ECG> getECG(){
        log.info("Foi à BD buscar o ECG!");
        //System.out.println("Foi à BD buscar o Helmet!");
        //System.out.println("---------------\n");
        return getECGRepository.findAll();
    }


    @GetMapping("/comp2")
    public String getComp2(){
        return "componente 2, acrescentear conteúdos";
    }

    // Obter a ultima mensagem recebida
    @GetMapping("/msg")
    public String getMsg(){
        return topicListener.getMessage();
    }

}
