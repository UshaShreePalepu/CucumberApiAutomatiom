package StepDefs;

import Data.EmploymentData;
import Runners.TestRunner;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmploymentDetails {
    Properties prop = new Properties();
    Response postResp;
    String reqBody;

    @BeforeStep()
    public void loadConfig() throws IOException{
        InputStream config = new FileInputStream("src/test/resources/Properties/environment.properties");
        prop.load(config);
    }

    @Given("the employment details with the {string}")
    public void the_employment_details_with_the(String name) {
       reqBody = EmploymentData.requestBody(name);
    }

    @When("the employment details are posted to create endpoint")
    public void the_employment_details_are_posted_to_create_endpoint() throws IOException {
        String baseUrl = prop.getProperty("baseUrl");
        postResp = RestAssured.given().baseUri(baseUrl + "/create")
                .body(reqBody)
                .when().post()
                .then().extract().response();
        postResp.prettyPrint();
    }

    @Then("the response status should be <SUCCESS>")
    public void the_response_status_should_be_success() {
        JsonPath respJson = postResp.getBody().jsonPath();
        String status = respJson.getString("status");

        Assert.assertEquals(status, "success");
    }
}
