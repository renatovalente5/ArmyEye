package com.project.ArmyEye;

import com.project.ArmyEye.Controllers.ArmyEyeController;
import com.project.ArmyEye.Models.GPS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
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
	void fileGPSExists() {

		File tmp = new File("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
		assert (tmp.exists());
	}

	@Test
	void fileGPSValid(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
			assert(l.size()!=0);
	}

	@Test
	void fileHelmetExists() {

		File tmp = new File("src/main/java/com/project/ArmyEye/sample_data/Helmet.tsv");
		assert (tmp.exists());
	}

	@Test
	void fileHelmetValid(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/Helmet.tsv");
		assert(l.size()!=0);
	}

	@Test
	void fileBatteryExists() {

		File tmp = new File("src/main/java/com/project/ArmyEye/sample_data/Unit_Battery.tsv");
		assert (tmp.exists());
	}

	@Test
	void fileBatteryValid(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/Unit_Battery.tsv");
		assert(l.size()!=0);
	}

	@Test
	void fileVitalECGExists() {

		File tmp = new File("src/main/java/com/project/ArmyEye/sample_data/VitalJacket_ECG.tsv");
		assert (tmp.exists());
	}

	@Test
	void fileVitalECGValid(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/VitalJacket_ECG.tsv");
		assert(l.size()!=0);
	}

	@Test
	void fileVitalOthersExists() {

		File tmp = new File("src/main/java/com/project/ArmyEye/sample_data/VitalJacket_others.tsv");
		assert (tmp.exists());
	}

	@Test
	void fileVitalOthersValid(){
		List<String[]> l=ArmyEyeController.tsvr("src/main/java/com/project/ArmyEye/sample_data/GPS.tsv");
		assert(l.size()!=0);
	}
}
