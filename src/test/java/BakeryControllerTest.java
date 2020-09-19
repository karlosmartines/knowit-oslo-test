
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.util.Map;
import java.util.Optional;

public class BakeryControllerTest {

    BakeryController bakeryController = new BakeryController();

    @Before
    public void beforeTests() {
        // Lag en metode som forbereder bakeryController til testene.
    }

    @Test
    public void registerIngredient() {
        String name = "mel";
        int quantity = 100;
        bakeryController.registerIngredient(name, quantity);

        Map.Entry<Ingredient, Integer> entry = bakeryController.ingredientStorage.entrySet().stream()
            .filter(i -> i.getKey().getName().equals(name))
            .findAny()
            .orElse(null);

        assertThat(entry.getValue(), greaterThanOrEqualTo(quantity));
    }

    @Test
    public void registerRecipe() {
    }

    @Test
    public void stockUpIngredient() {
    }
}
