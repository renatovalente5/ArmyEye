package com.project.ArmyEye;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.Helmet;
import com.project.ArmyEye.Models.VitalJacket_ECG;
import com.project.ArmyEye.repository.ECGRepository;
import com.project.ArmyEye.repository.GPSRepository;
import com.project.ArmyEye.repository.HelmetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringIntegrationTest {

    /*@Autowired
    private MockMvc mockMvc;

    @Autowired
    public GPSRepository gpsRepository;
    @Autowired
    public ECGRepository ecgRepository;
    @Autowired
    public HelmetRepository helmetRepository;

    @Test
    public void givenECG_whenGetArmy_thenConfirmValues()
            throws Exception {

        // given
        VitalJacket_ECG ecg = new VitalJacket_ECG("125.0");

        // when
        List<VitalJacket_ECG> repo = (List) ecgRepository.findAll();

        // then
        assert((repo.get(0).getECG()).equals(ecg.getECG()));
    }

    @Test
    public void givenGPS_whenGetArmy_thenConfirmValues()
            throws Exception {

        // given
        GPS gps = new GPS();
        gps.setAltitude("0.0");

        // when
        List<GPS> repo = (List) gpsRepository.findAll();

        // then
        assert((repo.get(0).getAltitude()).equals(gps.getAltitude()));
    }

    @Test
    void givenHelmet_whenGetArmy_thenConfirmValues() throws Exception {

        // given
        Helmet helmet = new Helmet();
        helmet.setCO("0.0");

        // when
        List<Helmet> repo = (List) helmetRepository.findAll();

        // then
        assert((repo.get(0).getCO()).equals(helmet.getCO()));
    }

    @Test
    void givenHelmet_whenGetArmy_thenConfirmBattery() throws Exception {

        // given
        Helmet helmet = new Helmet();
        helmet.setBattery("93.0");

        // when
        List<Helmet> repo = (List) helmetRepository.findAll();

        // then
        assert((repo.get(0).getBattery()).equals(helmet.getBattery()));
    }


    @Test
    void givenHelmet_whenGetArmy_thenConfirmNO() throws Exception {

        // given
        Helmet helmet = new Helmet();
        helmet.setNO2("-1.0");

        // when
        List<Helmet> repo = (List) helmetRepository.findAll();

        // then
        assert((repo.get(0).getNO2()).equals(helmet.getNO2()));
    }

    @Test
    void givenHelmet_whenGetArmy_thenConfirmLuminosity() throws Exception {

        // given
        Helmet helmet = new Helmet();
        helmet.setLuminosity("100.0");

        // when
        List<Helmet> repo = (List) helmetRepository.findAll();

        // then
        assert((repo.get(0).getLuminosity()).equals(helmet.getLuminosity()));
    }

    @Test
    void givenHelmet_whenGetArmy_thenConfirmHumidity() throws Exception {

        // given
        Helmet helmet = new Helmet();
        helmet.setHumidity("44.0");

        // when
        List<Helmet> repo = (List) helmetRepository.findAll();

        // then
        assert((repo.get(0).getHumidity()).equals(helmet.getHumidity()));
    }*/

}
