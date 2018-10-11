package jbpackage;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;


public class RequestJB extends Steps {
    Response resp;
    @Given("I send a request to the API")
    public void getRequest(){
        resp = RestAssured.get("https://restcountries.eu/rest/v2/alpha/col");
        resp.print();
        System.out.println(resp.getStatusCode());

    }
    @When("I check if status code is $code")
    public void checkStatusCode(int code){
       Assert.assertEquals(code, resp.getStatusCode());

    }
    @Then("the response must have the value $x")
    public void checkResponse (int x){
        String json = resp.asString();
        JsonPath jp = new JsonPath(json);
        Assert.assertEquals(jp.getInt("numericCode"), x);
    }


}
