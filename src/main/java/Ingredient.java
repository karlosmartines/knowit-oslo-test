public class Ingredient {
    int id;
    String name;
    int storedGrams;

    public Ingredient(int id, String name, int storedGrams) {
        this.id = id;
        this.name = name;
        this.storedGrams = storedGrams;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStoredGrams() {
        return storedGrams;
    }
}
