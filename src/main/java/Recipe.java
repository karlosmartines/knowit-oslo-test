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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Map getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map ingredients) {
        this.ingredients = ingredients;
    }
}
