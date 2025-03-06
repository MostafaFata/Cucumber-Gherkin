package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import operations.DrinkCatelog;
import operations.MorningFreshnessMember;
import operations.SuperSmoothieSchema;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Loyalty_Card_Program {

    private DrinkCatelog drinkCatelog = new DrinkCatelog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema(drinkCatelog);
    private MorningFreshnessMember michael;


    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        // streaming the Map
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    // storing values in variables
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));
                    // adding each drink and category to catelog
                    drinkCatelog.addDrink(drink, category);
                    // adding each category and points to schema
                    superSmoothieSchema.setPointsPerCategory(category, points);
                }
        );
    }

    @Given("^(.*) is a Morning Fresh Member$")
    public void michael_is_a_morning_fresh_member(String name) {
        michael = new MorningFreshnessMember(name, superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void michael_purchases_drinks(String name, Integer amount, String drink) {
        michael.orders(amount, drink);
    }

    @Then("he should earn {int} points")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(michael.getPoints()).isEqualTo(expectedPoints);
    }

}
