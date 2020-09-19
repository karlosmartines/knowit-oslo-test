import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.ErrorManager;

public class BakeryController {
    Set<Recipe> recipes = new HashSet();
    Map<Ingredient, Integer> ingredientStorage = new HashMap();
    int ingredientID = 0;
    int recipeID = 0;

    public BakeryController() {}

    int getIngredientID(){
        try{return ingredientID;}
        finally{ingredientID++;}
    }

    int getRecipeID(){
        try{return recipeID;}
        finally{recipeID++;}
    }

    void registerIngredient(String name, int storedGrams)
    {
        Ingredient ingredient = new Ingredient(getIngredientID(), name);
        if(!ingredientStorage.containsKey(name))
        {
            ingredientStorage.put(ingredient, storedGrams);
        }
        //else
        //{
        //    stockUpIngredient(ingredient.getId(), storedGrams);
        //}
    }

    void registerRecipe(String name, ProductType productType, Map ingredients)
    {
        recipes.add(new Recipe(getRecipeID(), name, new Date(), productType, ingredients));
    }

    void stockUpIngredient(int id, int quantityInGrams)
    {


    }
}
