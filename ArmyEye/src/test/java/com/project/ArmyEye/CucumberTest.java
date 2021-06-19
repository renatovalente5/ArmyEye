package com.project.ArmyEye;

import com.project.ArmyEye.Models.GPS;
import com.project.ArmyEye.Models.Helmet;
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

    private boolean out_of_limits = false;
    private GPS gps_solder;

    @Given("the soldier localization are being represented")
    public void the_soldier_localization_are_being_represented() {
        gps_solder = new GPS();
    }

    @When("there are values out of the recommended limits")
    public void there_are_values_out_of_the_recommended_limits() {
        gps_solder.setLatitude("35.764");
        if(Integer.parseInt(gps_solder.getLatitude()) < 0) out_of_limits = true;
    }

    @Then("it triggers an aid alert to a specific operational to move to a location")
    public void it_triggers_an_aid_alert_to_a_specific_operational_to_move_to_a_location(boolean expectedAnswer) {
        assertEquals(expectedAnswer, out_of_limits);
    }

    private VitalJacket_ECG ecg_solder;
    private boolean out_of_value = false;

    @Given("the ECG of the soldier are being presented")
    public void the_ECG_of_the_soldier_are_being_presented() {
        ecg_solder = new VitalJacket_ECG();
    }

    @When("needed to know the exact health state of an operational")
    public void needed_to_know_the_exact_health_state_of_an_operational() {
        ecg_solder.setECG("125.0");
        if(Integer.parseInt(ecg_solder.getECG()) > 110) out_of_value = true;
    }

    @Then("it is possible to check soldier ECG")
    public void it_is_possible_to_check_soldier_ECG(boolean expectedAnswer) {
        assertEquals(expectedAnswer, out_of_value);
    }

    private Helmet helmet_solder;
    private boolean out_of_value_helmet = false;

    @Given("the atmospheric conditions and geographic zones")
    public void the_atmospheric_conditions_and_geographic_zones() {
        ecg_solder = new VitalJacket_ECG();
    }

    @When("the values arent in the safety gap")
    public void the_values_arent_in_the_safety_gap() {
        helmet_solder.setCO("13.0");
        if(Integer.parseInt(helmet_solder.getCO()) > 0) out_of_value_helmet = true;
    }

    @Then("it triggers a general alert of prohibition to enter the danger zone")
    public void it_triggers_a_general_alert_of_prohibition_to_enter_the_danger_zone(boolean expectedAnswer) {
        assertEquals(expectedAnswer, out_of_value_helmet);
    }

}