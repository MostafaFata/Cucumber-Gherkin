package operations;

import java.util.HashMap;
import java.util.Map;

public class SuperSmoothieSchema {

    private Map<String, Integer> pointsPerCategory = new HashMap<>();
    private DrinkCatelog catelog;

    public SuperSmoothieSchema(DrinkCatelog catelog) {
        this.catelog = catelog;
    }

    public void setPointsPerCategory(String category, Integer points) {
        pointsPerCategory.put(category, points);
    }

    public int getPointsFor(String drink) {
        return pointsPerCategory.get(categoryOf(drink));
    }

    private String categoryOf(String drink) {
        return catelog.getCategory(drink);
    }
}
