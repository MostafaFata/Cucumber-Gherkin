package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


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

    @Given("grab data:")
    public void grab_data(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        System.out.println(data.get(0).get(0));

//        Map<String, String> userData = dataTable.asMap(String.class, String.class);
//
//        for (Map.Entry<String, String> entry : userData.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
//        }
//        String name = userData.get("Name");
//        String age = userData.get("Age");
//        System.out.println("User Name: " + name + ", Age: " + age);

    }
}
