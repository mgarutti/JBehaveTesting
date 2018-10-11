package jbpackage;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;


import java.lang.*;


public class BddTest extends Steps{

    int x;
    String validation;

    @Given("a specific number $number")
    public void specificNumber (@Named("number") int number){
    x = number;

    }
    @When("I sum the number $number")
    public void sum (@Named("number") int number){

        x = x + number;

    }
    @Then("number must be equal $number")
        public void validate (@Named("number") int number){
            if (x > number)
                    throw new RuntimeException("x is " + x + ", but should be " + number);

        }
    }
