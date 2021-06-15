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
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/myapp")
@CrossOrigin("*")
public class ArmyEyeController {

    private static final Logger LOG = Logger.getLogger(ArmyEyeController.class.getName());

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
    private int countHelmet = 0;
    private int countECG = 0;
    private int sentECGs=1;
    private int sentHelmet=1;
    private int sentGPS=1;
    private GPS passos = new GPS();
    private static LinkedList<GPS> armyGPS;
    private static LinkedList<Helmet> armyHelmet;
    private static LinkedList<VitalJacket_ECG> armyECG;

    private static LinkedList<GPS> armyGPSaux;
    private static LinkedList<Helmet> armyHelmetaux;
    private static LinkedList<VitalJacket_ECG> armyECGaux;

    private Map<String, LinkedList<GPS>> trackerArmyGPS = new HashMap<>();


    @GetMapping("/map")
    @Scheduled(fixedRate = 10000)
    public LinkedList<GPS> getMap() throws InterruptedException {

        LinkedList<GPS> passo = new LinkedList<GPS>();
        passo.add(passos);
        if(sentECGs==1000 || sentGPS==627 || sentHelmet==54){
            //fillLists();
            sentECGs=1;
            sentHelmet=1;
            sentGPS=1;
        }

        return passo;
    }

    @GetMapping("/fill")
    public void fill(){
        log.info("Starting APP");
        armyGPS = new LinkedList<>();
        //LinkedList<Comp1> auxList = new LinkedList<>();
        List<String[]> gps = tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
        for (String[] str : gps) {
            gpsRepository.save(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
            armyGPS.add(new GPS(str[0], str[1], str[2], str[3], str[4], str[5]));
            System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3] + " " + str[4] + " " + str[5]);
        }
        List<String[]> helmet = tsvr("src/main/java/com/project/ArmyEye/sample_data/Helmet.tsv");
        for (String[] str : helmet) {
            getHelmetRepository.save(new Helmet(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9]));
        }
//            List<String[]> battery = tsvr("src/main/java/com/project/ArmyEye/sample_data/Unit_Battery.tsv");
//            for (String[] str : battery) {
//                Repository.save(new Unit_Battery(str[0], str[1], str[2], str[3], str[4], str[5]));
//            }
        List<String[]> ecg = tsvr("src/main/java/com/project/ArmyEye/sample_data/VitalJacket_ECG.tsv");
        for (String[] str : ecg) {
            getECGRepository.save(new VitalJacket_ECG(str[0]));
        }
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
    public ArrayList<GPS> getComp1(){
        log.info("Foi à BD buscar o GPS!");
        ArrayList<GPS> aux = (ArrayList<GPS>) getGpsRepository.findAll();

        ArrayList<GPS> ret = new ArrayList<>();
        for(int i=0;i<sentGPS; i++) {
            ret.add(aux.get(i));
        }
        sentGPS++;
        Collections.reverse(ret);
        System.out.println("PASSO DADO!");

        passos = ret.get(0);
        String response = "Passo ->" + ret.get(0);
        LOG.log(Level.INFO, response);


        return ret;
    }

    @GetMapping("/helmet")
    @Scheduled(fixedRate = 100000)
    public ArrayList<Helmet> getHelmet(){
        log.info("Foi à BD buscar o Helmet!");
        ArrayList<Helmet> aux = (ArrayList<Helmet>) getHelmetRepository.findAll();

        if(sentHelmet >= aux.size()) { sentHelmet = 1; countHelmet++; }
        ArrayList<Helmet> ret = new ArrayList<>();
        if(countHelmet >= 1){ ret.addAll(aux); }
        for(int i=0;i<sentHelmet; i++) {
            ret.add(aux.get(i));
        }
/*        if(count%10==0) {
            sentHelmet++;
        }
        count++;*/
        sentHelmet++;

        Collections.reverse(ret);
        System.out.println("arrayHelmet: " + ret.get(0).CO);
        if((int) Double.parseDouble(ret.get(0).CO) > 0 ){
            topicProducer.send("co", "CO is too hight! - " + ret.get(0).CO);
        }
        return ret;
    }

    @GetMapping("/ecg")
    @Scheduled(fixedRate = 100000)
    public ArrayList<VitalJacket_ECG> getECG(){
        log.info("Foi à BD buscar o ECG!");
        ArrayList<VitalJacket_ECG> aux = (ArrayList<VitalJacket_ECG>) getECGRepository.findAll();

        ArrayList<VitalJacket_ECG> ret = new ArrayList<>();
        for(int i=0;i<sentECGs; i++) {
            ret.add(aux.get(i));
        }
        Collections.reverse(ret);

        return ret;

    }

    @GetMapping("/ecg2")
    @Scheduled(fixedRate = 100000)
    public ArrayList<Integer> getECG2(){
        log.info("Foi à BD buscar o ECG2!");
        ArrayList<VitalJacket_ECG> aux = (ArrayList<VitalJacket_ECG>) getECGRepository.findAll();

        if(sentECGs >= aux.size()) { countECG++; }
        ArrayList<Integer> ret = new ArrayList<>();
        if(countECG >= 1) {
            for(int i=0;i<sentECGs; i++) {
                ret.add((int) Double.parseDouble(aux.get(i).ECG));
            }
        }
        if(sentECGs >= aux.size()) { sentECGs = 1; }
        for(int i=0;i<sentECGs; i++) {
            ret.add((int) Double.parseDouble(aux.get(i).ECG));
        }
        sentECGs++;
        Collections.reverse(ret);
        System.out.println("ECG's: "+ ret);

        if(ret.get(0) > 124 ){
            topicProducer.send("ecg", "ECG is too hight! - " + ret.get(0));
        }

        return ret;
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

    @GetMapping("/msgCO")
    public String getMsgCO(){
        return topicListener.getMessageCO();
    }

}
