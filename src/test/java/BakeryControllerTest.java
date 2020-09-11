
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

public class BakeryControllerTest {

    BakeryController bakeryController = new BakeryController();

    @Test
    public void getIngredientID() {
    }

    @Test
    public void getRecipeID() {
    }

    @Test
    public void registerIngredient() {
        String name = "mel";
        int quantity = 100;
        Ingredient ingredient = bakeryController.registerIngredient(name, quantity);
        assertThat(bakeryController.allIngredients, contains(
            hasProperty("name", is(name))
        ));
    }

    @Test
    public void registerRecipe() {
    }

    @Test
    public void stockUpIngredient() {
    }
}
