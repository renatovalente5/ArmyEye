package com.project.ArmyEye;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty"}, publish = true)
@RunWith(Cucumber.class)
public class CucumberTest extends com.project.ArmyEye.SpringIntegrationTest {

}