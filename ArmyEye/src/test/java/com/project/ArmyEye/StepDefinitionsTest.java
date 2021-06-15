package com.project.ArmyEye;

import com.project.ArmyEye.Models.VitalJacket_ECG;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


class IsItFriday{
    static String isItFriday(String today){
        return "Friday".equals(today) ? "y" : "Nope";
    }
}

public class StepDefinitionsTest extends com.project.ArmyEye.SpringIntegrationTest {

    private String value;
    private boolean b;

/*    @Given("today is Sunday")
    public void start_with_125() { value = "125.0"; }

    @When("I ask whether it's Friday yet")
    public void i_ask_start_it_with_125() {
        List<VitalJacket_ECG> ecg_repo = (List) ecgRepository.findAll();
        b = ecg_repo.get(0).getECG().equals("125.0");
    }

    @Then("I should be told {string}")
    public void i_should_be_told_125(String string) {
        assertEquals(value, b);
    }*/
}
