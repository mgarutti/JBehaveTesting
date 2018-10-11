package jbpackage;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;



public class MockyTests {
    Response resp;
    String endpoint;
     public void getRequest(){
        resp = RestAssured.get("http://www.mocky.io/v2/" + endpoint);
        resp.print();
        System.out.println(resp.getStatusCode());

    }
    @Given("I send a request to the endpoint $endpoint")
    public void sendRequest(String endpoint){
    MockyTests mocky = new MockyTests();
    mocky.getRequest();
    }

}
