package operations;

import java.util.HashMap;
import java.util.Map;

public class DrinkCatelog {

    Map<String, String> drinkCategories = new HashMap<>();
    public void addDrink(String drink, String category) {
        drinkCategories.put(drink, category);
    }

    public String getCategory(String drink) {
        return drinkCategories.get(drink);
    }
}
