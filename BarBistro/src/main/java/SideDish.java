import java.util.List;

/*
getCalories() – Zsumowanie kalorii dania i wszystkich jego składników
 getWeight() – Zsumowanie wagi dania i wszystkich jego składników
 toString()
 getName()
 getDishCategory()
 getIngredients()
*/
public class SideDish extends Ingredient implements IDish{
    private double price;
    private IDish dish;

    public SideDish(String name, double weight, int calories, double price, IDish dish) {
        super(name, weight, calories);
        this.price = price;
        this.dish = dish;
    }

    public String getName(){
        return dish.getName() + " z " + super.getName();
    }

    public double getWeight(){
        double totalWeight = 0;
        for(Ingredient i : dish.getIngedients()){
            totalWeight += i.getWeight();
        }
        return totalWeight+super.getWeight();
    }

    public int getCalories(){
        int totalCalories = 0;
        for(Ingredient i : dish.getIngedients() ){
            totalCalories += i.getCalories();
        }
        return  totalCalories+super.getCalories();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public DishCategory getCategory() {
        return dish.getCategory();
    }

    @Override
    public List<Ingredient> getIngedients() {
        return dish.getIngedients();
    }

    @Override
    public String toString() {
        return "SideDish{" +
                "price=" + price +
                ", dish=" + dish +
                '}';
    }
}