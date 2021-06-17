package com.project.ArmyEye;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.VitalJacket_ECG;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty"}, publish = true)
@RunWith(Cucumber.class)
public class CucumberTest extends com.project.ArmyEye.SpringIntegrationTest {

}
