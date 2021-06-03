package Runners;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.TestNG;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "EmploymentDetails.feature",
        glue = "StepDefs",
        tags = "",
        plugin = {
                "pretty", "html:target/cucumber-report/repo"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
