package com.project.ArmyEye;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.Helmet;
import com.project.ArmyEye.Models.VitalJacket_ECG;
import com.project.ArmyEye.repository.ECGRepository;
import com.project.ArmyEye.repository.GPSRepository;
import com.project.ArmyEye.repository.HelmetRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringIntegrationTest {

    @Autowired
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
    void existValueHelmetinBD() throws Exception {

        List<Helmet> ecg_repo = (List) helmetRepository.findAll();
        assert((ecg_repo.get(0).getCO()).equals("0.0"));
    }

    @Test
    void existValueHelmet2inBD() throws Exception {

        List<Helmet> ecg_repo = (List) helmetRepository.findAll();
        assert((ecg_repo.get(0).getBattery()).equals("93.0"));
    }

/*
    @Test
    void existValueHelmet3inBD() throws Exception {

        List<Helmet> ecg_repo = (List) helmetRepository.findAll();
        assert((ecg_repo.get(0).getNO2()).equals("-1.0"));
    }

    @Test
    void existValueHelmet4inBD() throws Exception {

        List<Helmet> ecg_repo = (List) helmetRepository.findAll();
        assert((ecg_repo.get(0).getLuminosity()).equals("100.0"));
    }

    @Test
    void existValueHelmet5inBD() throws Exception {

        List<Helmet> ecg_repo = (List) helmetRepository.findAll();
        assert((ecg_repo.get(0).getHumidity()).equals("44.0"));
    }
*/
}
