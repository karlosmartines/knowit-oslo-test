import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.logging.ErrorManager;

public class BakeryController {
    ArrayList<Ingredient> allIngredients = new ArrayList<>();
    ArrayList<Recipe> allRecipes = new ArrayList<>();
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

    Ingredient registerIngredient(String name, int storedGrams){
        Ingredient ingredient = new Ingredient(getIngredientID(), name, storedGrams);
        allIngredients.add(ingredient);
        return ingredient;
    }

    void registerRecipe(String name, ProductType productType, Map ingredients){
        Date date = new Date();
        allRecipes.add(new Recipe(getRecipeID(), name, date, productType, ingredients));
    }

    int stockUpIngredient(int id, int quantityInGrams){
        Ingredient ingredient;
        for(Ingredient i : allIngredients){
            if(i.getId() == id){
                ingredient = i;
                ingredientStorage.put(ingredient, ingredientStorage.get(ingredient) + quantityInGrams);
                return ingredientStorage.get(ingredient);
            }
        }
        return -1;
    }
}
