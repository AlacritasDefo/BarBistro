import java.util.ArrayList;
import java.util.List;

public class Dish implements IDish {

    private String name;
    private Double price;
    private DishCategory category;
    private List<Ingredient> ingredients;


    @Override
    public double getWeight() {
        double totalWeight = 0;
        for(Ingredient i : ingredients ){
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }

    @Override
    public int getCalories() {
        int totalCalories = 0;
        for(Ingredient i : ingredients ){
            totalCalories += i.getCalories();
        }
        return  totalCalories;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public DishCategory getCategory() {
        return category;
    }

    @Override
    public List<Ingredient> getIngedients() {
        return ingredients;
    }
    public void addIngredients(Ingredient ... ingredients) throws BistroException{
        if (category == DishCategory.Vege) {
            String[] ing = new String[]{"mięs", "wołow", "wieprzow", "indyk",
                    "schabow", "stek", "kurczak", "barani", "rumsztyk"};
            for (Ingredient i : ingredients) {
                for (String s : ing) {
                    if (i.getName().contains(s))
                        throw new BistroException("Zawiera zakazany składnik: " + i.getName(),this);
                }
            }
        }
        this.ingredients.addAll(List.of(ingredients));
    }

    public Dish(String name, Double price, DishCategory category ) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = new ArrayList<>();
    }
    public boolean checkCategory(){
        if (category != DishCategory.Vege)
            return true;
        String[] ing = new String[]{"mięs", "wołow", "wieprzow", "indyk",
                "schabow", "stek", "kurczak", "barani", "rumsztyk" };
        for(Ingredient i : ingredients){
            for ( String s: ing){
                if (i.getName().contains(s))
                    return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
