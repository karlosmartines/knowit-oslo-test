
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import static junit.framework.TestCase.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BakeryControllerTest {

    BakeryController bakeryController = new BakeryController();
    Map<Ingredient, Integer> ingredientStorage = bakeryController.ingredientStorage;
    Set<Recipe> recipes = bakeryController.recipes;

    @Before
    public void beforeTests() {
        // Lag en metode som forbereder bakeryController til testene.
    ingredientStorage.put(new Ingredient(bakeryController.getIngredientID(), "sha256"), 256);
    ingredientStorage.put(new Ingredient(bakeryController.getIngredientID(), "mel"), 1000);
    ingredientStorage.put(new Ingredient(bakeryController.getIngredientID(), "melk"), 1000);
    ingredientStorage.put(new Ingredient(bakeryController.getIngredientID(), "egg"), 1000);
    }

    @Test
    public void registerIngredientTest()
    {
        String ingredientName = "kardemomme";
        int quantity = 100;
        bakeryController.registerIngredient(ingredientName, quantity);

        Map.Entry<Ingredient, Integer> entry = ingredientStorage.entrySet().stream()
            .filter(i -> i.getKey().getName().equals(ingredientName))
            .findAny()
            .orElse(null);

        assertThat(entry.getValue(), greaterThanOrEqualTo(quantity));
    }

    @Test
    public void registerRecipeTest()
    {
        String recipeName = "hashkake";
        ProductType productType = ProductType.ANNET_BAKVERK;
        Map<Ingredient, Integer> ingredients = new HashMap();

        ingredients.put(ingredientStorage.keySet().stream()
                .filter(i -> i.getName().equals("sha256"))
                .findAny()
                .orElse(null),
            256
        );
        ingredients.put(ingredientStorage.keySet().stream()
                .filter(i -> i.getName().equals("mel"))
                .findAny()
                .orElse(null),
            500
        );
        ingredients.put(ingredientStorage.keySet().stream()
                .filter(i -> i.getName().equals("egg"))
                .findAny()
                .orElse(null),
            500
        );
        ingredients.put(ingredientStorage.keySet().stream()
                .filter(i -> i.getName().equals("melk"))
                .findAny()
                .orElse(null),
            500
        );

        bakeryController.registerRecipe(recipeName, productType, ingredients);

        assertNotNull(recipes.stream()
            .filter(r -> r.getName().equals(recipeName))
            .findAny()
            .orElse(null)
        );
        // Dette virker jo som en dustete måte å gjøre det på.
        // I hvilke tilfeller, og hvorfor, skal man bruke assertThat
        assertThat(recipes, contains(recipes.stream()
            .filter(r -> r.getName().equals(recipeName))
            .findAny()
            .orElse(null))
        );
    }

    @Test
    public void stockUpIngredient() {
    }
}
