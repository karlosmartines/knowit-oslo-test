import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Recipe {
    int id;
    String name;
    Date date;
    ProductType productType;
    Map ingredients;

    public Recipe(int id, String name, Date date, ProductType productType, Map ingredients) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.productType = productType;
        this.ingredients = ingredients;
    }
}
