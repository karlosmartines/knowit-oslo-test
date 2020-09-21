import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.ErrorManager;
import java.util.stream.Collectors;

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

    void stockUpIngredient(int id, int stockUpQuantity)
    {
        Ingredient ingredient = ingredientStorage.keySet().stream()
            .filter(i -> i.getId() == id)
            .findAny()
            .orElse(null); // Kanskje en orElseThrow istedet her?

        ingredientStorage.put(ingredient, ingredientStorage.get(ingredient) + stockUpQuantity);
    }

    List<Recipe> getAllRecipesOfType(ProductType productType)
    {
        return recipes.stream()
            .filter(r -> r.getProductType().equals(productType))
            .sorted((r1, r2) -> r1.getName().compareTo(r2.getName()))
            .collect(Collectors.toList());
    }

    List<Recipe> getAllRecipesRegisteredBetween(Date startDate, Date endDate)
    {
        return recipes.stream()
            .filter(r -> r.getDate().after(startDate) && r.getDate().before(endDate))
            .collect(Collectors.toList());
    }

    boolean gotStorageToProduce(int recipeId, int numberOfProducts)
    {
        Recipe recipe = recipes.stream()
            .filter(r -> r.getId() == recipeId)
            .findAny()
            .orElseThrow(IllegalArgumentException::new);

        for(Integer i : recipe.getIngredients().values().stream().mapToInt() )

        Collection<Integer> neededIngredients = recipe.getIngredients().values().stream()
            .forEach(value -> value *= numberOfProducts);

    }
}
