package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class Start {

    private String msg;

    @Given("user initiates the test")
    public void user_initiates_the_test() {
        System.out.println("user has initiated the test!");
    }
    @When("user prints {string}")
    public void user_prints(String message) {
        System.out.println("User prints " + message);
        this.msg = message;
    }
    @Then("{string} is printed")
    public void is_printed(String actualMessage) {
        Assert.assertEquals(msg, actualMessage);
        System.out.println("test passed");

    }
}
