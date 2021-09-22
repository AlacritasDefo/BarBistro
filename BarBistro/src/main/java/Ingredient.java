public class Ingredient {

   private String name;
    private double weight;
    private int calories;

    public double getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public Ingredient(String name, double weight, int calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                '}';
    }
}
