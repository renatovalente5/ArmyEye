package com.project.ArmyEye;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.ArmyEye.Controllers.ArmyEyeController;
import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.Helmet;
import com.project.ArmyEye.Models.VitalJacket_ECG;
import com.project.ArmyEye.repository.ECGRepository;
import com.project.ArmyEye.repository.GPSRepository;
import com.project.ArmyEye.repository.HelmetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import scala.concurrent.impl.Promise;

import java.io.File;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ArmyEyeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private GPSRepository gpsRepository;
	@Autowired
	private ECGRepository ecgRepository;
	@Autowired
	private HelmetRepository helmetRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void checkGPSTest(){
//		Set<String> set=ArmyEyeController.getArmyGPS().stream().map(GPS::getAltitude).filter(x -> Integer.parseInt(x)<0).collect(Collectors.toSet());
//		assert (set.size()!=0);
//	}

/*	@Test
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
	}*/

/*	@Test
	public void getReact() throws Exception {
		System.out.println("Request React");
		this.mockMvc.perform(get("http://192.168.160.87:21004/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getSpring() throws Exception {
		System.out.println("Request Spring");
		this.mockMvc.perform(get("http://192.168.160.87:21001/")).andDo(print()).andExpect(status().isOk());
	}*/

/*	@Test
	public void getGPS() throws Exception {
		System.out.println("Request GPS");
		this.mockMvc.perform(get("http://192.168.160.87:21001/gps")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void emptyGPS() throws Exception {
		List<GPS> testlist= (List<GPS>) gpsRepository.findAll();
		assert (testlist.size()>0);
	}

	@Test
	public void emptyECG() throws Exception {
		List<VitalJacket_ECG> testlist= (List<VitalJacket_ECG>) ecgRepository.findAll();
		assert (testlist.size()>0);
	}

	@Test
	public void emptyHelmet() throws Exception {
		List<Helmet> testlist= (List<Helmet>) helmetRepository.findAll();
		assert (testlist.size()>0);
	}*/
}
