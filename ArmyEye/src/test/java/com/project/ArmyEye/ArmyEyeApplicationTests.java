package com.project.ArmyEye;

import com.project.ArmyEye.Controllers.ArmyEyeController;
import com.project.ArmyEye.Models.GPS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class ArmyEyeApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	void checkGPSTest(){
//		Set<String> set=ArmyEyeController.getArmyGPS().stream().map(GPS::getAltitude).filter(x -> Integer.parseInt(x)<0).collect(Collectors.toSet());
//		assert (set.size()!=0);
//	}

	@Test
	void checkFile(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
			assert(l.size()!=0);
	}
}
