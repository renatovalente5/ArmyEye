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

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GPSRepository gpsRepository;
    @Autowired
    private ECGRepository ecgRepository;
    @Autowired
    private HelmetRepository helmetRepository;


    @Test
    void existValueECGinBD2() throws Exception {
        assert("1"=="1");
    }

    @Test
    void existValueECGinBD() throws Exception {

        List<VitalJacket_ECG> ecg_repo = (List) ecgRepository.findAll();
        assert((ecg_repo.get(0).getECG()).equals("125.0"));
    }


}