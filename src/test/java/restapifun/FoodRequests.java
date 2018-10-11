package restapifun;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import jbpackage.MockyTests;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class FoodRequests {
    Response resp;
    String uri = "https://api.edamam.com/api/food-database/parser?ingr=";
    String foodName;
    String appId = "&app_id="; //signup on https://developer.edamam.com/food-database-api to get info;
    String appKey = "&app_key="; //signup on https://developer.edamam.com/food-database-api to get info;


    public void getRequest(String foodName){
        resp = RestAssured.get(uri + foodName + appId + appKey);
        resp.print();
        System.out.println(resp.getStatusCode());


  }

    @Given("I search for the food $foodName")
    public void sendRequest(String foodName ){

      getRequest(foodName);

    }
    @When("I check if the status code is $code")
    public void checkStatusCode(int code){

        Assert.assertEquals(code, resp.getStatusCode());

    }
    @Then("the response must have the value $value")
    public void getValue(String value){
        String json = resp.asString();
        JsonPath jp = new JsonPath(json);
        Assert.assertEquals(value, jp.getString("parsed.food[0].foodId"));
    }
    //food id food_b0bn6w4ab49t55b1o8jsnbq6nm2g
}
