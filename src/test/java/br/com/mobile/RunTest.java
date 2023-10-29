package br.com.mobile;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json:target/reports/cucumberTest.json", "html:target/reports/"},
        tags = {"@test"},
        glue = {"br.com.mobile"})
public class RunTest {
    @AfterClass
    public static void closeApp(){
        Hooks.quitDriver();
    }
}